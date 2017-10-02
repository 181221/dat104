package no.pederyo.controller.info;

import no.pederyo.utils.InnloggingUtil;
import no.pederyo.dataaccess.BrukerEAO;
import no.pederyo.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static no.pederyo.utils.FlashUtil.Flash;
import static no.pederyo.controller.UrlMappings.BETALINGSINFO;
import static no.pederyo.controller.UrlMappings.LOGGINNKASSERER;

/**
 * Created by Peder on 29.09.2017.
 */

public class BetalingsInfoServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobil = request.getParameter("mobil");
        Bruker b = brukerEAO.finnBruker(mobil);
        b.setHarBetalt(true);
        brukerEAO.oppdaterBruker(b);
        response.sendRedirect(BETALINGSINFO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnLoggetSomKasserer(request)){
            List<Bruker> brukere = brukerEAO.finnAlleBrukere();
            request.getSession().setAttribute("brukere", brukere);
            request.getRequestDispatcher("WEB-INF/betalingsinfo.jsp").forward(request,response);
        }else {
            Flash(request, "Error", "Du må være innlogget som Kasserer for å gjøre det!");
            response.sendRedirect(LOGGINNKASSERER);
        }

    }
}
