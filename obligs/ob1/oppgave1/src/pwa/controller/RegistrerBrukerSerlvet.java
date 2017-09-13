package pwa.controller;

import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
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
    private HandlelisteEAO handlelisteEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)){
            response.sendRedirect("/handleliste");
        }
        String brukernavn = request.getParameter("username");
        String passord = request.getParameter("password");
        if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
            //Opprette en ny bruker
            handlelisteEAO.leggTilBruker(brukernavn, passord);
            //lage flash
            FlashUtil.registrertBruker(request);
            // sende redirect
            response.sendRedirect("/handliste");
        }else {
            // feil input
            FlashUtil.UgylidRegistertBruker(request);
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
}
