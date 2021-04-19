package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示沾包和半包问题
 */
public class TCPClientError {
    // ip
    private static final String ip = "127.0.0.1";
    // 端口号
    public static final int port = 9005;

    public static void main(String[] args) throws IOException {
        // 创建 socket 并尝试连接服务器端
        Socket socket = new Socket(ip, port);
//        String msg = "Hello, Java~\n";
//        // 得到写入（发送）对象
//        try (OutputStream outputStream = socket.getOutputStream()) {
//            for (int i = 0; i < 10; i++) {
//                // 发送消息给服务器端
//                outputStream.write(msg.getBytes());
//                outputStream.flush();
//            }
//        }

        String msg = "Hello, Java~";
        // 得到写入（发送）对象
        try (OutputStream outputStream = socket.getOutputStream()) {
            // 规定每个流的大小就是 1024
            byte[] bytes = new byte[1024]; // 最终发送的数据
            int index = 0;
            // 将 msg 里面的内容全部移动到 bytes 里面
            for (byte item : msg.getBytes()) {
                bytes[index] = item;
                index++;
            }
            for (int i = 0; i < 10; i++) {
                // 发送消息给服务器端
                outputStream.write(bytes);
                outputStream.flush();
            }
        }
    }
}
