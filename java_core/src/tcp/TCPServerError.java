package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 演示沾包和半包问题
 */
public class TCPServerError {
    // 端口号
    private static final int port = 9005;
    // 内容长度
    private static final int leng = 1024;

    public static void main(String[] args) throws IOException {
        // 创建 TCP 服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动");
        // 得到客户端连接
        Socket socket = serverSocket.accept();
        // 当代码执行到此行，表示已经有客户端连接
        System.out.println(String.format("已有客户端连接了，IP：%s，Port：%d",
                socket.getInetAddress().getHostAddress(), socket.getPort()));
//        // 得到读取对象
//        try (InputStream inputStream = socket.getInputStream()) {
//            while (true) {
//                byte[] bytes = new byte[leng];
//                // 将内容读取到数组中
//                int result = inputStream.read(bytes, 0, leng);
//                if (result > 0) {
//                    String msg = new String(bytes);
//                    System.out.println("收到客户端内容：" + msg);
//                }
//            }
//        }

//        // 沾包解决方案 1【以\n作为流的边界来处理沾包和半包问题】
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(socket.getInputStream()))) {
//            while (true) {
//                // 按行分隔读取内容
//                String msg = reader.readLine();
//                if (msg != null && !msg.equals("")) {
//                    System.out.println("收到客户端消息：" + msg);
//                }
//            }
//        }

        // 半包和沾包问题解决方案2：发送固定大小的流信息
        // 得到读取对象
        try (InputStream inputStream = socket.getInputStream()) {
            while (true) {
                byte[] bytes = new byte[leng];
                // 将内容读取到数组中
                int result = inputStream.read(bytes, 0, leng);
                if (result > 0) {
                    String msg = new String(bytes);
                    System.out.println("收到客户端内容：" + msg.trim());
                }
            }
        }
    }
}
