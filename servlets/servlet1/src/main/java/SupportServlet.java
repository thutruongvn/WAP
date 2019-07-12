import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class SupportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Support</title></head><body>");
        out.print("<form method='post'>");
        out.print("<div><span>Name:   </span>");
        out.print("<input type='text' name='txtName'/></div>");
        out.print("<div><span>Email:  </span>");
        out.print("<input type='text' name='txtEmail'/></div>");
        out.print("<div><span>Problem: </span>");
        out.print("<input type='text' name='txtProblem'/></div>");
        out.print("<div><span>Problem description:</span></div>");
        out.print("<div><textarea name='txtProbDesc'></textarea></div>");
        out.print("<div><input type='submit' value='Help'/></div>");
        out.print("</form>");
        out.print("</body></html>");
        req.getServletContext().setAttribute("supportEmail", "helpdesk2@support.mum.edu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String supportEmail = req.getServletContext().getAttribute("supportEmail").toString();
        String supportID = getRandomString();
        String email = req.getParameter("txtEmail");
        String name = req.getParameter("txtName");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Support</title></head><body>");
        out.print("<p>Thank you! " + name + " for contacting us. " +
                "We should receive reply from us with in 24 hrs in your email address " + email + ". " +
                "Let us know in our support email " + supportEmail + " if you don't receive reply within 24 hrs. " +
                "Please be sure to attach your reference " + supportID + " in your email.</p>");
        out.print("</body></html>");
    }

    private String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder s = new StringBuilder();
        Random rnd = new Random();
        while (s.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            s.append(SALTCHARS.charAt(index));
        }
        String str = s.toString();
        return str;

    }
}
