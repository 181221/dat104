package pwa.controller;



import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
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

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @EJB
    private HandlelisteEAO handlelisteEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brukernavn = request.getParameter("username");
        String passord = request.getParameter("password");
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn) && passord.equals(handlelisteEAO.finnBrukerPaaNavn(brukernavn).getPassord())){
            InnloggingUtil.loggInnSom(request, brukernavn);
            response.sendRedirect("/handleliste?message=" + URLEncoder.encode(FlashUtil.message, "UTF-8"));
        }else {
            FlashUtil.UgyldigBruker(request);
            response.sendRedirect("/login?message=" + URLEncoder.encode(FlashUtil.message, "UTF-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }
}
