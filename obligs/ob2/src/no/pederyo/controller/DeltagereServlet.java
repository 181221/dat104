package no.pederyo.controller;

import no.pederyo.app.InnloggingUtil;
import no.pederyo.dataaccess.BrukerEAO;
import no.pederyo.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static no.pederyo.controller.UrlMappings.DELTAGERLISTE;
import static no.pederyo.controller.UrlMappings.PAAMELDFEIL;
import static no.pederyo.controller.UrlMappings.PAAMELDING_URL;

/**
 * Created by Peder on 29.09.2017.
 */
@WebServlet(name = "DeltagereServlet", urlPatterns = DELTAGERLISTE)
public class DeltagereServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)) {
            List<Bruker> brukere = brukerEAO.finnAlleBrukere();
            request.getSession().setAttribute("brukere", brukere);
            request.getRequestDispatcher("WEB-INF/deltagere.jsp").forward(request, response);
        } else {
            response.sendRedirect(PAAMELDING_URL);
        }
    }

}
