package no.pederyo.controller;

import no.pederyo.app.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelddingsbekreftelse", urlPatterns = UrlMappings.PAAMELDINGSBEKREFTELSE_URL)
public class PaaMeldBekreftServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/paameldbekreft.jsp").forward(request,response);
    }
}
