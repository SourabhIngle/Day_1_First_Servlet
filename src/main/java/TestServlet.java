import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the response content type to "text/html"
        response.setContentType("text/html");

        // Get a PrintWriter object to write the response output
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello welcome to servlet demo</h1>");
        out.close();
    }
}
