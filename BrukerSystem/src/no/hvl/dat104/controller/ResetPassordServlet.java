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
import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */
//reseter passord
public class ResetPassordServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brukernavn = request.getParameter("brukernavn");
        Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
        System.out.println(b.getEmail());
        if(b != null) {
            String fra = "peder.wig@gmail.com";
            String passord = "huwyaka123";
            Mail m = MailUtil.setUpMail(b.getEmail(), fra, passord);
            try {
                oppdaterNyttPassord(request, m.getMsg(), brukerEAO);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            MailUtil.setUpProps(m, request);
            Flash(request, "Succuss", "Sjekk mail");
        }
        Flash(request, "Error", "Brukeren eksisterer ikke");
        response.sendRedirect(LOGIN_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)){
            request.getRequestDispatcher("WEB-INF/settings.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("WEB-INF/reset.jsp").forward(request, response);
        }
    }
}
