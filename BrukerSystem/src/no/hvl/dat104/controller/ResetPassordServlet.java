package no.hvl.dat104.controller;

import no.hvl.dat104.app.FlashUtil;
import no.hvl.dat104.app.InnloggingUtil;
import no.hvl.dat104.app.MailUtil;
import no.hvl.dat104.app.SHA;
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

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */

public class ResetPassordServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String til = request.getParameter("email");
        String fra = "peder.wiig@gmail.com";
        String passord = "Wpoxns147";
        Mail m = MailUtil.setUpMail(til,fra,passord);
        try {
            lagNyttPassord(request, m);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        MailUtil.setUpProps(m, request);
        FlashUtil.Flash(request, "Succuss", "Sjekk mail");
        response.sendRedirect(LOGIN_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            request.getRequestDispatcher("WEB-INF/reset.jsp").forward(request, response);
        }else {
            FlashUtil.Flash(request,"Error", "Du må være innlogget!");
            response.sendRedirect(LOGIN_URL);
        }
    }
    private void lagNyttPassord(HttpServletRequest request, Mail mail) throws NoSuchAlgorithmException {
        Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
        String hashetPassord = SHA.SHA1Hash(mail.getMsg());
        b.setPassord(hashetPassord);
        brukerEAO.oppdaterBruker(b);
    }
}
