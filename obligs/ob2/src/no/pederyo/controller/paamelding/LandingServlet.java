package no.pederyo.controller.paamelding;

import no.pederyo.app.InnloggingUtil;
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

import static no.pederyo.app.FlashUtil.Flash;
import static no.pederyo.app.SjekkOpplysninger.sjekkCookies;
import static no.pederyo.app.SjekkOpplysninger.sjekkPersonOpplysninger;
import static no.pederyo.controller.UrlMappings.PAAMELDFEIL;
import static no.pederyo.controller.UrlMappings.PAAMELDINGSBEKREFTELSE_URL;
import static no.pederyo.controller.UrlMappings.PAAMELDING_URL;

/**
 * Created by Peder on 27.09.2017.
 */

public class LandingServlet extends HttpServlet {
    @EJB
    BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean riktig = false;
        List<Cookie> cookies = sjekkPersonOpplysninger(request, response);
        if(sjekkCookies(cookies, request)) {
            if(sjekkOmtelefonEksisterer(request)) {
                riktig = true;
                Bruker ny = opprettBruker(request);
                InnloggingUtil.loggInnSom(request, ny);
                request.getSession().setAttribute("ny", ny);
                request.getSession().setAttribute("riktig", riktig);

            }else {
                Flash(request,"Error", "Det eksisterer allerede en bruker med det telefonnummeret");
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
    private Bruker opprettBruker(HttpServletRequest request) {
       String fornavn = ValidatorUtil.escapeHtml(request.getParameter("fornavn"));
       String etternavn = ValidatorUtil.escapeHtml(request.getParameter("etternavn"));
       String mobil = ValidatorUtil.escapeHtml(request.getParameter("mobil"));
       String kjonn = ValidatorUtil.escapeHtml(request.getParameter("kjonn"));
       Bruker b = setBrukerInfo(fornavn,etternavn,mobil,kjonn);
       brukerEAO.leggTilBruker(b);
       return b;
    }
    private Bruker setBrukerInfo(String fornavn, String etternavn, String mobil, String kjonn) {
        Bruker b = new Bruker();
        b.setFornavn(fornavn);
        b.setEtternavn(etternavn);
        b.setHarBetalt(false);
        b.setTelefon(mobil);
        b.setKjonn(kjonn);
        return b;
    }

    private boolean sjekkOmtelefonEksisterer(HttpServletRequest request) {
        String mobil = request.getParameter("mobil");
        Bruker b = brukerEAO.finnBruker(mobil);
        return b == null;
    }

}
