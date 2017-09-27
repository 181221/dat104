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

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelding", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cookie> cookies = sjekkPersonOpplysninger(request);
        if(sjekkCookies(cookies)) {
            // det er verdier i alle cookiesene nå må Eg sjekke fnavn etternavn og mobil.
        }else {
            System.out.println("du har et par feil her");
        }
        //hentPersonOpplysninger(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

}
