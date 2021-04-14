package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServer {
    //端口号（不可变）
    private static final int port = 9001;
    //数据最大长度
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //启动一个UDP服务器端(IP\端口号)
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已启动");
        while (true) {
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            //等待客户端的连接
            socket.receive(clientPacket);
            //执行到此，表示已有客户端连接
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息:" + msg);
            //给客户端一个响应
            String serMsg = "是的。";
            //发送消息
            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,//注意是字节长度不是字符串长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);
        }
    }
}
