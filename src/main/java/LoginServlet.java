import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")// Annotation basically use for metadata means additional information.
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");

        boolean loginName = userName.equals("Sourabh");
        boolean loginPassword = password.equals("Password123@");

        if (loginName && loginPassword) {
            response.sendRedirect("success.jsp");
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            if (!loginName && !loginPassword) {
                out.println("<font color=\"red\">Incorrect username and password. </font>");
                requestDispatcher.include(request, response);
            } else if (!loginName) {
                out.println("<font color=\"red\">Invalid username.</font>");
                requestDispatcher.include(request, response);
            } else {
                out.println("<font color=\"red\">Incorrect password. </font>");
                requestDispatcher.include(request, response);
            }
        }
    }
}
