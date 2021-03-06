package lph.controller;

import lph.dataaccess.VareEAO;
import lph.model.Vare;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/slett")
public class SlettServlet extends HttpServlet {
    @EJB
    private VareEAO vareEAO;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String slett = request.getParameter("varenavn");
        Vare varen = vareEAO.finnVare(slett);
        System.out.println(varen.getItem());
        vareEAO.slettVare(varen);
        response.sendRedirect("vare");
    }

}
