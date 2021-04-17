package tcp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器端
 */
public class TCPServer {
    //端口号
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {
        //创建并启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器 已启动");
        //等待客户端连接
        Socket clientSocket = serverSocket.accept();
        //当执行到这一步，表示已有客户端连接
        System.out.println(String.format("已有客户端连接，IP:%s，端口号：%d",
        clientSocket.getInetAddress().getHostAddress(),
        clientSocket.getPort()));
        //jdk 7 try-resource
        try(
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()))
                        ){
                            //收发消息
                            String msg = reader.readLine();
                            System.out.println("接收到客户端消息："+msg);
                            //给客户端一个反馈消息
                            String serMsg = "收到";
                            writer.write(serMsg+"\n");
                            writer.flush();
                        }
//        //收发消息
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(clientSocket.getInputStream())
//        );
//        //接收客户端消息
//        String msg = reader.readLine();
//        System.out.println("接收到客户端消息："+msg);
//        reader.close();
//        //给客户端反馈
//        String serMsg = "我收到了";
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(clientSocket.getOutputStream())
//        );
//        writer.write(serMsg + "\n");//"\n"不能省略
//        //发送缓冲区刷新操作[执行此步骤将缓冲区的消息给发送出去]
//        writer.flush();
    }
}
