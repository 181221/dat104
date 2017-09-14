package lph.controller;

import lph.app.InnloggingUtil;
import lph.dataaccess.BrukerEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Peder on 06.09.2017.
 */
@WebServlet("/login")
public class RegistrereServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brukernavn = request.getParameter("username");
        boolean riktigbruker = false;
        if(brukernavn == null || InnloggingUtil.isGyldigBrukernavn(brukernavn) == false){
            riktigbruker = true;
            request.setAttribute("riktigbruker", riktigbruker);
            response.sendRedirect("index.jsp");

        }else {
            HttpSession sesjon = request.getSession(false);
            if(sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(10);
            sesjon.setAttribute("brukernavn", brukernavn);
            response.sendRedirect("hemmelig.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("riktigbruker", true);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
