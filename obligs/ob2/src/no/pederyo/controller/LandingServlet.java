package no.pederyo.controller;

import no.hvl.dat104.app.CookiesUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelding", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        sjekkPersonOpplysninger(request);
        //hentPersonOpplysninger(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
    private String sjekkPersonOpplysninger(HttpServletRequest request) {
        Enumeration<String> k = request.getParameterNames();
        while (k.hasMoreElements()){
            String param = k.nextElement();
            CookiesUtil.getCookie(request,"heui");
            System.out.println(param);
        }
        return null;
    }
}
