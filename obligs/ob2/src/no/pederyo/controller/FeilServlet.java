package no.pederyo.controller;

import no.pederyo.app.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.controller.UrlMappings.PAAMELDFEIL;

/**
 * Created by Peder on 28.09.2017.
 */
@WebServlet(name = "FeilServlet", urlPatterns = PAAMELDFEIL)
public class FeilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fornavn = CookiesUtil.getCookieValue(request,"fornavn");
        String etternavn = CookiesUtil.getCookieValue(request,"etternavn");
        String mobil = CookiesUtil.getCookieValue(request,"mobil");
        request.getSession().setAttribute("fornavn", fornavn);
        request.getSession().setAttribute("etternavn", etternavn);
        request.getSession().setAttribute("mobil", mobil);
        request.getRequestDispatcher("WEB-INF/paameldbekreftfeil.jsp").forward(request,response);
    }
}
