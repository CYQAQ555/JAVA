import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String num1 = req.getParameter("number1");
        String num2 = req.getParameter("number2");
        int total = Integer.parseInt(num1) + Integer.parseInt(num2);
        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h1>结果为：%d</h1>",total));
    }
}