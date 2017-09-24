package no.hvl.dat104.controller;

import no.hvl.dat104.app.FlashUtil;
import no.hvl.dat104.app.InnloggingUtil;
import no.hvl.dat104.app.SHA;
import no.hvl.dat104.app.ValidatorUtil;
import no.hvl.dat104.dataaccess.BrukerEAO;
import no.hvl.dat104.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static no.hvl.dat104.controller.UrlMappings.REGISTRER_URL;
import static no.hvl.dat104.controller.UrlMappings.SECRET_URL;

/**
 * Created by Peder on 24.09.2017.
 */

public class RegistrerBrukerServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)){
            response.sendRedirect(SECRET_URL);
        }else {
            try {
                sjekkBrukerInfoOgLeggTilBruker(request, response);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(REGISTRER_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect(SECRET_URL);
        }else {
            request.getRequestDispatcher("WEB-INF/registrer.jsp").forward(request,response);
        }

    }
    private void sjekkBrukerInfoOgLeggTilBruker(HttpServletRequest req, HttpServletResponse res) throws NoSuchAlgorithmException {
        String brukernavn = ValidatorUtil.escapeHtml(req.getParameter("username"));
        String passord = ValidatorUtil.escapeHtml(req.getParameter("password"));
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)) {
            if(brukerEAO.sjekkOmBrukerErRegistrert(brukernavn)) {
                String hashedPassord = SHA.SHA1Hash(passord);
                Bruker ny = brukerEAO.leggTil(brukernavn, hashedPassord);
                FlashUtil.Flash(req,"Success", "Velkommen");
                InnloggingUtil.loggInnSom(req, ny);
            }else {
                String melding = "Det eksisterer allerede en bruker med brukernavnet: " + brukernavn;
                FlashUtil.Flash(req, "Error", melding);
            }
        }else {
            FlashUtil.Flash(req, "Error", "Ugyldig input");
        }
        return;
    }
}
