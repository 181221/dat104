package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/result")
public class Servlet extends HttpServlet {

    Map<Integer,Integer> stemme;
    Map<Integer,String> partier;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int valget = (int) request.getSession().getAttribute("valg");
        stemme.put(valget, stemme.get(valget)+1);
        request.getSession().setAttribute("stemme", stemme);
        request.getSession().setAttribute("partier", partier);
        request.getRequestDispatcher("resultat.jsp").forward(request,response);
    }
    @Override
    public void init() throws ServletException {
        stemme = new HashMap<>();
        partier = new HashMap<>();
        String[] parti = {"Sv","Ap","Rodt","Venstre"};
        for(int i = 0; i < parti.length; i ++) {
            stemme.put(i,0);
            partier.put(i,parti[i]);
        }
    }
}
