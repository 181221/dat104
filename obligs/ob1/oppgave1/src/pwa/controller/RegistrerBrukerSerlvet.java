package pwa.controller;


import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
import pwa.app.SHA1;
import pwa.app.ValidatorUtil;
import pwa.dataaccess.BrukerEAO;
import pwa.dataaccess.HandlelisteEAO;
import pwa.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static pwa.controller.UrlMappings.HANDLELISTE_URL;
import static pwa.controller.UrlMappings.REGISTER_URL;

/**
 * Created by Peder on 13.09.2017.
 */
public class RegistrerBrukerSerlvet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)){
            response.sendRedirect(HANDLELISTE_URL);
        }else {
            try {
                sjekkBrukerInfoOgLeggTilBruker(request, response);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(REGISTER_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect(HANDLELISTE_URL);
        }else {
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request,response);
        }
    }

    private void sjekkBrukerInfoOgLeggTilBruker(HttpServletRequest req, HttpServletResponse res) throws NoSuchAlgorithmException {
        String brukernavn = ValidatorUtil.escapeHtml(req.getParameter("username"));
        String passord = ValidatorUtil.escapeHtml(req.getParameter("password"));
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)) {
            if(brukerEAO.sjekkOmBrukerErRegistrert(brukernavn)) {
                String hashedPassord = SHA1.SHA1Hash(passord);
                Bruker ny = brukerEAO.leggTil(brukernavn, hashedPassord);
                FlashUtil.registrertBruker(req);
                String timeout = getServletContext().getInitParameter("timeout");
                InnloggingUtil.loggInnSom(req, ny, timeout);
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
