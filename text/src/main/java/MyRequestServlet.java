import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String method = request.getMethod();

        String uri = request.getRequestURI();

        String contentType = request.getContentType();

        PrintWriter writer = response.getWriter();
        writer.println(String.format("<h1>method:%d</h1>",method));
        writer.println(String.format("<h1>uri:%d</h1>",uri));
        writer.println(String.format("<h1>contentType:%d</h1>",contentType));


    }
}
