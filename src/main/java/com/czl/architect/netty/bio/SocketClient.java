package com.czl.architect.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1",9000);
             OutputStream outputStream = clientSocket.getOutputStream();
             InputStream inputStream = clientSocket.getInputStream()) {
            outputStream.write("HellowServer".getBytes());
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            if (read != -1) {
                System.out.println("收到服务端消息：" + new String(bytes, 0, read));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
