import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse
            response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String method = request.getMethod();
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String title = "HTTP Function Test!";
        String docType = "<!doctype html>\n";
        out.println(docType + "<html>\n" +
                "<head><title>" +title+ "</title></head>\n" +
                "<body>"+
                "<h1> method: " +method+ "</h1>" +
                "<h1> first_name: " +first_name+ "</h1>" +
                "<h1> last_name: " +last_name+ "</h1>" +
                "</body>"+
                "</html>");
    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request,response);
    }
}
