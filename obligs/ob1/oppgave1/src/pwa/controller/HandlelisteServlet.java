package pwa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/handleliste")
public class HandlelisteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedInUser") != null){
            request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request,response);
        }else {
            String message = "Du må være logget inn for å gjøre det!";
            String flash = "Error";
            request.getSession().setAttribute("flash", flash);
            response.sendRedirect("/login?message=" + URLEncoder.encode(message, "UTF-8"));
        }

    }
}
