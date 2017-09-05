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
        ValutaBeregner beregner = new ValutaBeregner();
        double resultat = 0;
        boolean gyldig;
        String fraBelop = request.getParameter("fra-belop");
        String fraCur = request.getParameter("currency-fra");
        String tilCur = request.getParameter("currency-til");

        if(beregner.isValidBelop(fraBelop)){ //sjekker om belop er riktig verdi
            double omgjorfraBelop = Double.parseDouble(fraBelop);
            resultat = ValutaBeregner.BeregnValuta(fraCur, tilCur, omgjorfraBelop); //bergnValute sjekker om Cur er riktig
            gyldig = true;
        }else {
            gyldig = false;
        }
        request.setAttribute("gyldig", gyldig);
        request.setAttribute("fra", fraBelop);
        request.setAttribute("til", tilCur);
        request.setAttribute("fraCur", fraCur);
        request.setAttribute("resultat", String.format("%.2f", resultat));
        request.getRequestDispatcher("resultat.jsp").forward(request, response);
    }
}
