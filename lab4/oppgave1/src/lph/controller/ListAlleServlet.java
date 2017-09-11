package lph.controller;

import lph.dataaccess.VareEAO;
import lph.model.Vare;
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
@WebServlet("/vare")
public class ListAlleServlet extends HttpServlet {

    @EJB
    private VareEAO vareEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vare = request.getParameter("vare");

        Vare nyVare = new Vare();
        nyVare.setItem(vare);

        vareEAO.leggTilVare(nyVare);
        response.sendRedirect("vare");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vare> alleVarer = vareEAO.alleVarer();
        System.out.println(alleVarer.get(0).getItem());
        request.setAttribute("alleVarer", alleVarer);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
