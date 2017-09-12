package pwa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        if(request.getSession().getAttribute("loggedInUser") != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                String flash = "Success";
                request.getSession().setAttribute("flash", flash);
                message = "Du er nå logget ut";
            }
        }
        response.sendRedirect("/login?message=" + URLEncoder.encode(message, "UTF-8"));
    }
}
