package no.pederyo.controller.login;

import no.pederyo.utils.InnloggingUtil;
import no.pederyo.utils.ValidatorUtil;
import no.pederyo.dataaccess.BrukerEAO;
import no.pederyo.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.utils.FlashUtil.Flash;
import static no.pederyo.controller.UrlMappings.DELTAGERLISTE;
import static no.pederyo.controller.UrlMappings.LOGIN;

/**
 * Created by Peder on 29.09.2017.
 */

public class LoginServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobil = request.getParameter("mobil");
        if(ValidatorUtil.isValidTelefon(mobil)) {
            Bruker b = brukerEAO.finnBruker(mobil);
            if(b != null) {
                InnloggingUtil.loggInnSom(request, b);
            }
            Flash(request,"Error","Feil passord");
        }else {
            Flash(request, "Error", "Ikke gyldig telefon nummer!");
        }
        response.sendRedirect(LOGIN);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect(DELTAGERLISTE);
        }else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        }
    }
}
