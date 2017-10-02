package no.pederyo.controller.login;

import no.pederyo.utils.InnloggingUtil;
import no.pederyo.utils.ValidatorUtil;
import no.pederyo.dataaccess.BrukerEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.controller.UrlMappings.BETALINGSINFO;
import static no.pederyo.controller.UrlMappings.LOGGINNKASSERER;
import static no.pederyo.utils.FlashUtil.Flash;

/**
 * Created by Peder on 29.09.2017.
 */

public class LoggInnKassererServlet extends HttpServlet {
    @EJB
    BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passord = request.getParameter("passord");
        if(ValidatorUtil.isValidTelefon(passord)) {
            if(passord.equals(getServletConfig().getInitParameter("kassererPassord"))){
                InnloggingUtil.loggInnSomKasserer(request);
            }else {
                Flash(request, "Error", "Feil passord");
            }
        }else {
            Flash(request, "Error","Ugyldig input");
        }
        response.sendRedirect(LOGGINNKASSERER);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnLoggetSomKasserer(request)) {
            response.sendRedirect(BETALINGSINFO);
        }else {
            request.getRequestDispatcher("WEB-INF/kasserer.jsp").forward(request,response);
        }

    }
}
