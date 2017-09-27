package no.pederyo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static no.pederyo.app.SjekkOpplysninger.sjekkCookies;
import static no.pederyo.app.SjekkOpplysninger.sjekkPersonOpplysninger;
import static no.pederyo.controller.UrlMappings.PAAMELDINGSBEKREFTELSE_URL;
import static no.pederyo.controller.UrlMappings.PAAMELDING_URL;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelding", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean riktig = false;
        List<Cookie> cookies = sjekkPersonOpplysninger(request);
        if(sjekkCookies(cookies)) {
            //legg til bruker i databasen
            riktig = true;
            request.getSession().setAttribute("riktig", riktig);
        }else {
            request.getSession().setAttribute("riktig", riktig);
        }
        response.sendRedirect(PAAMELDING_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object b = request.getSession().getAttribute("riktig");
        if(b != null) {
            if((boolean) b  == true){
                response.sendRedirect(PAAMELDINGSBEKREFTELSE_URL);
            }
        }else {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
        }


    }

}
