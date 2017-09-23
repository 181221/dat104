package pwa.controller;



import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

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
        String brukernavn = request.getParameter("username");
        String passord = request.getParameter("password");
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
            Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
            if(b != null && passord.equals(b.getPassord())){
                String timeout = getServletContext().getInitParameter("timeout");
                InnloggingUtil.loggInnSom(request, b, timeout);
            }else {
                FlashUtil.Flash(request,"Error","Ugyldig input");
            }
        }else {
            FlashUtil.Flash(request,"Error","Ugyldig brukernavn eller passord");
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
    public void init() throws ServletException {

    }
}
