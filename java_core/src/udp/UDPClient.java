package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
        //服务器IP
        private static final String ip = "127.0.0.1";
        //服务器端口号
        private static final int port = 9001;
        //数据最大长度
        private static final int bleng = 1024;
        public static void main(String[] args) throws IOException {
            //启动客户端
            DatagramSocket client = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("我:");
                String msg = scanner.nextLine();
                //给服务器端发送消息
                DatagramPacket datagramPacket = new DatagramPacket(
                        msg.getBytes(),
                        msg.getBytes().length,
                        InetAddress.getByName(ip),
                        port
                );
                client.send(datagramPacket);
                //接收服务器返回信息
                DatagramPacket serPacket = new DatagramPacket(
                        new byte[bleng],
                        bleng
                );
                client.receive(serPacket);
                //接收到服务器端的信息
                String serMsg = new String(serPacket.getData());
                System.out.println("rgzz:" + serMsg);
            }
        }
}
