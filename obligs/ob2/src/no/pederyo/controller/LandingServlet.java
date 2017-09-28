package no.pederyo.controller;

import no.pederyo.app.ValidatorUtil;
import no.pederyo.dataaccess.BrukerEAO;
import no.pederyo.model.Bruker;

import javax.ejb.EJB;
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
import static no.pederyo.controller.UrlMappings.PAAMELDFEIL;
import static no.pederyo.controller.UrlMappings.PAAMELDINGSBEKREFTELSE_URL;
import static no.pederyo.controller.UrlMappings.PAAMELDING_URL;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelding", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    @EJB
    BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean riktig = false;
        List<Cookie> cookies = sjekkPersonOpplysninger(request, response);
        if(sjekkCookies(cookies, request)) {
            //TODO
            if(sjekkOmtelefonEksisterer(request)) {
                riktig = true;
                opprettBruker(request);
                request.getSession().setAttribute("riktig", riktig);
            }else {
                request.getSession().setAttribute("riktig", riktig);
            }
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
            }else {
                response.sendRedirect(PAAMELDFEIL);
            }
        }else {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
        }
    }
    private void opprettBruker(HttpServletRequest request) {
       String fornavn = ValidatorUtil.escapeHtml(request.getParameter("fornavn"));
       String etternavn = ValidatorUtil.escapeHtml(request.getParameter("etternavn"));
       String mobil = ValidatorUtil.escapeHtml(request.getParameter("mobil"));
       String kjonn = ValidatorUtil.escapeHtml(request.getParameter("kjonn"));
        System.out.println(fornavn);
        System.out.println(etternavn);
        System.out.println(mobil);
        System.out.println(kjonn);

    }

    private boolean sjekkOmtelefonEksisterer(HttpServletRequest request) {
        String mobil = request.getParameter("mobil");
        Bruker b = brukerEAO.finnBruker(mobil);
        return b == null;
    }

}
