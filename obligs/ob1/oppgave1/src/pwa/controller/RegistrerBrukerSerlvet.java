package pwa.controller;


import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;
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

/**
 * Created by Peder on 13.09.2017.
 */
@WebServlet("/register")
public class RegistrerBrukerSerlvet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)){
            response.sendRedirect("/handleliste");
        }else {
            String brukernavn = request.getParameter("username");
            String passord = request.getParameter("password");
            if(InnloggingUtil.isGyldigBrukernavn(brukernavn, passord)){
                Boolean lagtTil = brukerEAO.leggTilBruker(brukernavn, passord);
                Bruker b = brukerEAO.finnBrukerPaaNavn(brukernavn);
                if(lagtTil){
                    FlashUtil.registrertBruker(request);
                    InnloggingUtil.loggInnSom(request, b, getInitParameter("timeout"));
                }else {
                    FlashUtil.UgylidRegistertBruker(request);
                }
            }
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
