package com.czl.netty.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * selector+selectionKey(SocketChannel+selector)可监听连接、读、写
 * 1.服务端：启动，新建ServerSocketChannel，注册到selector，生成selectionKey(ServerSocketChannel+selector)，负责监听连接事件。
 * 2.客户端：启动，新建SocketChannel和selector，然后与服务端端口建立连接。
 * 3.服务端：selector监听到连接，取出第1步的selectionKey，取到ServerSocketChannel，用ServerSocketChannel新建一个SocketChannel，注册到selector负责监听读操作。
 * 4.客户端：建立连接成功后，把SocketChannel注册到客户端的selector，生成selectionKey，负责监听连接事件。
 * 5.客户端：监听到第4步连接成功。取出第4步新建的selectionKey，取出SocketChannel，向该Channel写入"HelloServer"，并把该Channel注册到selector，负责监听读事件。
 * 6.服务端：第3步中监听读事件的selector，监听到第5步客户端的事件。从selector中取出channel（第3步中的那个channel），从通道中读取到数据"HelloServer"。然后向通道写数据"HelloClient"。
 * 7.客户端：第5步中最后负责监听的selector，监听到第6步中服务端的数据，收到"HelloClient"。客户端完成，客户端的selector继续轮询事件。
 * 8.服务端：监听到第6步中自己的写事件，取到channel，取消监听写事件，只监听读事件。
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {
        //创建两个线程组bossGroup和workerGroup, 含有的子线程NioEventLoop的个数默认为cpu核数的两倍
        // bossGroup只是处理连接请求 ,真正的和客户端业务处理，会交给workerGroup完成
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //创建服务器端的启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            //使用链式编程来配置参数
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用NioServerSocketChannel作为服务器的通道实现
                    // 初始化服务器连接队列大小，服务端处理客户端连接请求是顺序处理的,所以同一时间只能处理一个客户端连接。
                    // 多个客户端同时来的时候,服务端将不能处理的客户端连接请求放在队列中等待处理
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建通道初始化对象，设置初始化参数

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //对workerGroup的SocketChannel设置处理器
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("netty server start。。");
            //绑定一个端口并且同步, 生成了一个ChannelFuture异步对象，通过isDone()等方法可以判断异步事件的执行情况
            //启动服务器(并绑定端口)，bind是异步操作，sync方法是等待异步操作执行完毕
            ChannelFuture cf = bootstrap.bind(9000).sync();
            //给cf注册监听器，监听我们关心的事件
            /*cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口9000成功");
                    } else {
                        System.out.println("监听端口9000失败");
                    }
                }
            });*/
            //对通道关闭进行监听，closeFuture是异步操作，监听通道关闭
            // 通过sync方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}