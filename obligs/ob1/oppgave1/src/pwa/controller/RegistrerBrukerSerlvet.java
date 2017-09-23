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

import static pwa.controller.UrlMappings.HANDLELISTE_URL;
import static pwa.controller.UrlMappings.REGISTER_URL;

/**
 * Created by Peder on 13.09.2017.
 */
@WebServlet
public class RegistrerBrukerSerlvet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)){
            response.sendRedirect(HANDLELISTE_URL);
        }else {
            String brukernavn = ValidatorUtil.escapeHtml(request.getParameter("username"));
            String passord = ValidatorUtil.escapeHtml(request.getParameter("password"));
            if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
                Boolean lagtTil = brukerEAO.leggTilBruker(brukernavn, passord);
                Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
                if(lagtTil){
                    FlashUtil.registrertBruker(request);
                    String timeout = getServletContext().getInitParameter("timeout");
                    InnloggingUtil.loggInnSom(request, b, timeout);
                }else {
                    String melding = "Det eksisterer allerede en bruker med brukernavnet: " + brukernavn;
                    FlashUtil.Flash(request,"Error", melding);
                }
            }
            else {
                FlashUtil.Flash(request,"Error","Ugyldig input");
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
}
