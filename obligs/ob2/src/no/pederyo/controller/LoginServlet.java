package no.pederyo.controller;

import no.pederyo.app.FlashUtil;
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

import static no.pederyo.app.FlashUtil.Flash;
import static no.pederyo.controller.UrlMappings.DELTAGERLISTE;
import static no.pederyo.controller.UrlMappings.LOGIN;

/**
 * Created by Peder on 29.09.2017.
 */
@WebServlet(name = "LoginServlet", urlPatterns = LOGIN)
public class LoginServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobil = request.getParameter("mobil");
        System.out.println();
        if(ValidatorUtil.isValidTelefon(mobil)) {
            Bruker b = brukerEAO.finnBruker(mobil);
            System.out.println(b.getFornavn());
            if(b != null) {
                InnloggingUtil.loggInnSom(request, b);
            }
        }
        response.sendRedirect(LOGIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect(DELTAGERLISTE);
        }else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        }

    }
}
