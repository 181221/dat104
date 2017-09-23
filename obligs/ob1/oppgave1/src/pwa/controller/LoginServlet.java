package pwa.controller;



import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
import pwa.app.SHA1;
import pwa.app.ValidatorUtil;
import pwa.dataaccess.BrukerEAO;
import pwa.dataaccess.HandlelisteEAO;
import pwa.model.Bruker;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import static pwa.controller.UrlMappings.HANDLELISTE_URL;
import static pwa.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 12.09.2017.
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
            response.sendRedirect(HANDLELISTE_URL);
        }else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        }
    }
    public void sjekkBrukerInfoOgLoggInn(HttpServletRequest req, HttpServletResponse res) throws NoSuchAlgorithmException {
        String brukernavn = ValidatorUtil.escapeHtml(req.getParameter("username"));
        String passord = ValidatorUtil.escapeHtml(req.getParameter("password"));
        if (InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
            Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
            String hashedPassord = SHA1.SHA1Hash(passord);
            if(b != null && hashedPassord.equals(b.getPassord())) {
                String timeout = getServletContext().getInitParameter("timeout");
                InnloggingUtil.loggInnSom(req, b, timeout);
            }else {
                FlashUtil.Flash(req,"Error","Ugyldig input");
            }
        } else {
            FlashUtil.Flash(req,"Error","Ugyldig brukernavn eller passord");
        }
        return;
    }

    public void init() throws ServletException {

    }
}
