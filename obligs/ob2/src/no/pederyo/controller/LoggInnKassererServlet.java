package no.pederyo.controller;

import no.pederyo.app.InnloggingUtil;
import no.pederyo.app.ValidatorUtil;
import no.pederyo.dataaccess.BrukerEAO;
import no.pederyo.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.controller.UrlMappings.BETALINGSINFO;
import static no.pederyo.controller.UrlMappings.LOGGINNKASSERER;

/**
 * Created by Peder on 29.09.2017.
 */
@WebServlet(name = "LoggInnKassererServlet", urlPatterns = LOGGINNKASSERER)
public class LoggInnKassererServlet extends HttpServlet {
    @EJB
    BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passord = request.getParameter("passord");
        if(ValidatorUtil.isValidTelefon(passord)) {
            if(passord.equals(getServletConfig().getInitParameter("kassererPassord"))){
                InnloggingUtil.loggInnSomKasserer(request);
            }
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
