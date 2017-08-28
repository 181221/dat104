package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/resultat")
public class ValutaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String message = "Hello World";

        String fraBelop = request.getParameter("fra-belop");
        String tilCur = request.getParameter("til-currenzy");

        String fraCur = request.getParameter("fra-currenzy");


        double resultat = ValutaBeregner.BeregnValuta(fraBelop, tilCur);

        double finalResult = resultat * Double.parseDouble(fraBelop);

        //request.setAttribute("message", message); // This will be available as ${message}
        request.setAttribute("fra", fraBelop);
        request.setAttribute("til", tilCur);
        request.setAttribute("fraCur", fraCur);

        request.setAttribute("resultat", finalResult);
        request.getRequestDispatcher("resultat.jsp").forward(request, response);
    }
}
