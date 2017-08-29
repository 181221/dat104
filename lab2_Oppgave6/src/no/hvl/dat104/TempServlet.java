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
            System.out.println(b.getTemp());
            System.out.print(b.getTemp() >= -273.15);
        }else {
            b = new Beregn();
        }
        if(tempVal.equals("celsius") && b.getTemp() >= -273.15){
            System.out.println("tempen er " + b.getTemp());
            omregning = b.omregnFraCtilF();
            gyldig = true;
        } else if (tempVal.equals("fahrenheit") && b.getTemp() >= -459.67){
            omregning = b.omregnFraFtilC();
            gyldig = true;
        } else {
            omregning = 0.0;
            gyldig = false;
        }

        request.setAttribute("gyldig",gyldig);
        request.setAttribute("tempVal", tempVal);
        request.setAttribute("tempen", tempen);
        request.setAttribute("omregning", String.format("%.1f", omregning));
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

}
