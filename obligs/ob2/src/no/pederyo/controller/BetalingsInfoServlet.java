package no.pederyo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.controller.UrlMappings.BETALINGSINFO;

/**
 * Created by Peder on 29.09.2017.
 */
@WebServlet(name = "BetalingsInfoServlet", urlPatterns = BETALINGSINFO)
public class BetalingsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("du postet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hei");
        request.getRequestDispatcher("WEB-INF/betalingsinfo.jsp").forward(request,response);
    }
}
