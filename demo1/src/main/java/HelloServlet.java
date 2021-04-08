import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class HelloServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {// 如果不存在 session 会话，则创建一个 session 对象
        HttpSession session = request.getSession(true);
    // 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
    // 获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String title = "欢迎回来";
        String visitCountKey = new String("visitCount");
        Integer visitCount = 0;
        String userIDKey = new String("userID");
        String userID = new String("abcd");
    // 检查网页上是否是新的访问者
        if(session.isNew()){
            title = "欢迎来到我的网站";
            session.setAttribute(userIDKey, userID);
        } else{
        visitCount = (Integer) session.getAttribute(visitCountKey);
        visitCount++;
        userID = (String)session.getAttribute(userIDKey);
    }
        session.setAttribute(visitCountKey,visitCount);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String docType = "<!doctype html>\n";
        out.println(docType + "<html>\n" +
                "<head><title>" +title+ "</title></head>\n" +
                "<body>\n" +
                "<h1>" + title + "</h1>\n"+
                "<h2> Session 信息 </h2>" +
                "<p>" +
                "ID: " + session.getId() + "<hr/><br/>"+
                "Create Time: " + createTime + "<hr/><br/>"+
                "Time of Last Access: " + lastAccessTime + "<hr/><br/>"+
                "User ID: " + userID + "<hr/><br/>"+
                "Number of visits: " + visitCount + "<hr/><br/>"+
                "</p>"+ "</body>" +
                "</html>");
    }
}
