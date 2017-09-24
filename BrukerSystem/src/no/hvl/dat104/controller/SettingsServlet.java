package no.hvl.dat104.controller;

import no.hvl.dat104.app.FlashUtil;
import no.hvl.dat104.app.InnloggingUtil;
import no.hvl.dat104.app.SHA;
import no.hvl.dat104.app.ValidatorUtil;
import no.hvl.dat104.dataaccess.BrukerEAO;
import no.hvl.dat104.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static no.hvl.dat104.app.GenererPassord.oppdaterNyttPassord;
import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;
import static no.hvl.dat104.controller.UrlMappings.SETTINGS_URL;

/**
 * Created by Peder on 24.09.2017.
 */

public class SettingsServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passord = ValidatorUtil.escapeHtml(request.getParameter("password"));
        String passord1 = ValidatorUtil.escapeHtml(request.getParameter("password1"));
        if(passord.equals(passord1)) {
            if(ValidatorUtil.isValidPassword(passord)) {
                try {
                    oppdaterNyttPassord(request, passord, brukerEAO);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                FlashUtil.Flash(request, "Success", "Passord er oppdatert");
            }
        }else {
            FlashUtil.Flash(request, "Error", "Finner ikke brukeren!");
        }
        response.sendRedirect(SETTINGS_URL);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            request.getRequestDispatcher("WEB-INF/settings.jps").forward(request, response);
        }else {
            FlashUtil.Flash(request, "Error", "Du må være logget inn");
            response.sendRedirect(LOGIN_URL);
        }
    }
}
