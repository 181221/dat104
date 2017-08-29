package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 28.08.2017.
 */
@WebServlet("/beregn")
public class TempServlet extends HttpServlet {
    Beregn b;
    double omregning;
    boolean gyldig;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempVal = request.getParameter("radio1"); // celsius eller fahr
        String tempen = request.getParameter("temperatur"); // gradene

        if(Beregn.isValidTemp(tempen)){
            b = new Beregn(Double.parseDouble(tempen));
            gyldig = true;
        }else {
            b = new Beregn();
            gyldig = false;
        }

        if(tempVal.equals("celsius")){
            omregning = b.omregnFraCtilF();
        } else if (tempVal.equals("fahrenheit")){
            omregning = b.omregnFraFtilC();
        } else {
            omregning = 0.0;
        }

        request.setAttribute("gyldig",gyldig);
        request.setAttribute("tempVal", tempVal);
        request.setAttribute("tempen", tempen);
        request.setAttribute("omregning", String.format("%.1f", omregning));
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

}
