package no.hvl.dat104.controller;

import no.hvl.dat104.app.*;
import no.hvl.dat104.dataaccess.BrukerEAO;
import no.hvl.dat104.model.Bruker;
import no.hvl.dat104.model.Mail;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static no.hvl.dat104.app.FlashUtil.Flash;
import static no.hvl.dat104.app.GenererPassord.oppdaterNyttPassord;
import static no.hvl.dat104.app.GenererPassord.oppdaterNyttPassordUtenAAVeareInnlogget;
import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */
//reseter passord
public class ResetPassordServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Bruker b = brukerEAO.finnBrukerPaaEmail(email);
        if(b != null) {
            String fra = "DINMAIL@gmail.com";
            String passord = "DITTPASSORD";
            //finn mailen
            Mail m = MailUtil.setUpMail(b.getEmail(), fra, passord);
            MailUtil.setUpProps(m, request);
            Flash(request, "Succuss", "Sjekk mail");
            try {
                oppdaterNyttPassordUtenAAVeareInnlogget(b, m.getMsg(), brukerEAO);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("WEB-INF/resetinfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)){
            request.getRequestDispatcher("WEB-INF/settings.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("WEB-INF/reset.jsp").forward(request, response);
        }
    }
}
