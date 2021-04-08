import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在方法开头通过属性、编码和数据类型
        //设置编码防止乱码
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();//获得写入流
        writer.println("<h1 style='color:red'>Hello,World~</h1>");
    }
}
