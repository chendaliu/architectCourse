package com.czl.architect.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * bio一个客户端对应一个线程
 */
public class SocketServer {
    public static void main(String[] args) {
        try (final ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("========== 准备接受客户端消息 ==========");
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            while (true) {
                executorService.execute(() -> {
                    try (Socket clientSocket = serverSocket.accept();
                         InputStream inputStream = clientSocket.getInputStream();
                         OutputStream outputStream = clientSocket.getOutputStream()) {

                        System.out.println("========== 有客户端连接了 ==========");
                        byte[] bytes = new byte[1024];
                        int read = inputStream.read(bytes);
                        if (read != -1) {
                            System.out.println("接受到客户端数据:" + new String(bytes, 0, read));
                        }

                        outputStream.write("HelloClient".getBytes());
                        outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
