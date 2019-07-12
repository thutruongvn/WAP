import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenFilter", urlPatterns = {"/login", "/logout"})
public class AuthenFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest)req;
        HttpServletResponse httpResp = (HttpServletResponse)resp;
        User curUser = (User)httpReq.getSession(false).getAttribute("currentUser");
        if(httpReq.getServletPath().equals("logoutServlet") && curUser == null) {
            httpResp.sendRedirect("/");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
