package lph.controller;

import lph.dataaccess.BrukerEAO;
import lph.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 06.09.2017.
 */
@WebServlet("/reg")
public class RegistrereServlet extends HttpServlet {
    @EJB
    private BrukerEAO brukerEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");

        Bruker nyBruker = new Bruker();
        nyBruker.setNavn(fornavn);
        nyBruker.setEtternavn(etternavn);

        brukerEAO.leggTilBruker(nyBruker);
        response.sendRedirect("listAlle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("du har gettet");
    }
}
