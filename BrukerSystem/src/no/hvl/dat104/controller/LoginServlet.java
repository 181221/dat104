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

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */
@WebServlet
public class LoginServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sjekkBrukerInfoOgLoggInn(request, response);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        response.sendRedirect(LOGIN_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)){
            response.sendRedirect(UrlMappings.SECRET_URL);
        }else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        }
    }
    public void sjekkBrukerInfoOgLoggInn(HttpServletRequest req, HttpServletResponse res) throws NoSuchAlgorithmException {
        String brukernavn = ValidatorUtil.escapeHtml(req.getParameter("username"));
        String passord = ValidatorUtil.escapeHtml(req.getParameter("password"));
        if (InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
            Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
            String hashedPassord = SHA.SHA1Hash(passord);
            if(b != null && hashedPassord.equals(b.getPassord())) {
                InnloggingUtil.loggInnSom(req, b);
            }else {
                FlashUtil.Flash(req,"Error","Ugyldig input");
            }
        } else {
            FlashUtil.Flash(req,"Error","Ugyldig brukernavn eller passord");
        }
        return;
    }

}
