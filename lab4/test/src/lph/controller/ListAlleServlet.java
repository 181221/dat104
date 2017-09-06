package lph.controller;

import lph.dataaccess.BrukerEAO;
import lph.model.Bruker;
import org.omg.CORBA.Request;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Peder on 06.09.2017.
 */
@WebServlet("/listalle")
public class ListAlleServlet extends HttpServlet {

    @EJB
    private BrukerEAO brukerEAO;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bruker> alleBrukere = brukerEAO.alleBrukere();
        request.setAttribute("alleBrukere", alleBrukere);
        request.getRequestDispatcher("resultat.jsp").forward(request,response);
    }
}
