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
            if(tempVal.equals("celsius") && b.getTemp() >= -273.15){
                omregning = b.omregnFraCtilF();
                gyldig = true;
            }else if (tempVal.equals("fahrenheit") && b.getTemp() >= -459.67){
                omregning = b.omregnFraFtilC();
                gyldig = true;
            } else {
                gyldig = false;
            }
        }else {
            gyldig = false;
            b = new Beregn();
        }

        System.out.println(gyldig);
        request.setAttribute("gyldig",gyldig);
        request.setAttribute("tempVal", tempVal);
        request.setAttribute("tempen", b.getTemp());
        request.setAttribute("omregning", String.format("%.1f", omregning));
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

}
