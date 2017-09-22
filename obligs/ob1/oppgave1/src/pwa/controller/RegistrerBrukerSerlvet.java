package pwa.controller;


import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
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

/**
 * Created by Peder on 13.09.2017.
 */
@WebServlet("/register")
public class RegistrerBrukerSerlvet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect("/handleliste");
        }else {
            sjekkBrukerInfoOgLeggTilBruker(request, response);
        }
        response.sendRedirect("/register");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect("/handleliste");
        }else {
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request,response);
        }
    }

    private void sjekkBrukerInfoOgLeggTilBruker(HttpServletRequest req, HttpServletResponse res) {
        String brukernavn = ValidatorUtil.escapeHtml(req.getParameter("username"));
        String passord = ValidatorUtil.escapeHtml(req.getParameter("password"));
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)) {
            if(brukerEAO.sjekkOmBrukerErRegistrert(brukernavn)) {
                Bruker ny = brukerEAO.leggTil(brukernavn, passord);
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
     /*String brukernavn = ValidatorUtil.escapeHtml(request.getParameter("username"));
            String passord = ValidatorUtil.escapeHtml(request.getParameter("password"));
            if (sjekkBrukerInfo(request, response)) {
                Boolean lagtTil = brukerEAO.leggTilBruker(brukernavn, passord);
                Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
                if (lagtTil) {
                    FlashUtil.registrertBruker(request);
                    String timeout = getServletContext().getInitParameter("timeout");
                    InnloggingUtil.loggInnSom(request, b, timeout);
                } else {
                    String melding = "Det eksisterer allerede en bruker med brukernavnet: " + brukernavn;
                    FlashUtil.Flash(request, "Error", melding);
                }
            } else {
                FlashUtil.Flash(request, "Error", "Ugyldig input");
            }
        }*/
}
