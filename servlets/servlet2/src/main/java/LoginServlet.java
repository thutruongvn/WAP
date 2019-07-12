import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserAccess.addUser(new User("test1","123"));
        UserAccess.addUser(new User("test2","123"));
        UserAccess.addUser(new User("test3","123"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("txtUsername");
        String ps = request.getParameter("txtPassword");
        User user = new User(un, ps);
        if(UserAccess.validateAccount(user)) {
            Cookie loginCookie = new Cookie("username",user.getUsername());
            loginCookie.setMaxAge(30*24*60*60); //1 month
            response.addCookie(loginCookie);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            PrintWriter out = response.getWriter();
            out.print("<html><head><title>Welcome</title></head><body>");
            out.print("<h1>Welcome " + un + "</h1>");
            out.print("<a href='logout'>Logout</a>");
            out.print("</body></html>");
        } else {
            response.sendRedirect("/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }
}
