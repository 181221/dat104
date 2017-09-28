package no.pederyo.controller;

import no.pederyo.app.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static no.pederyo.controller.UrlMappings.PAAMELDFEIL;

/**
 * Created by Peder on 28.09.2017.
 */
@WebServlet(name = "FeilServlet", urlPatterns = PAAMELDFEIL)
public class FeilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setUpCookiesTilRequest(request);
        setUpfeilMeldinger(request);
        request.getRequestDispatcher("WEB-INF/paameldbekreftfeil.jsp").forward(request,response);
    }
    private void setUpfeilMeldinger(HttpServletRequest request) {
        HashMap<String, String> feil = (HashMap<String, String>) request.getSession().getAttribute("feilmeldinger");
        String feilfornavn = feil.get("fornavn");
        String feiletternavn = feil.get("etternavn");
        String feilmobil = feil.get("mobil");
        request.getSession().setAttribute("feilfornavn", feilfornavn);
        request.getSession().setAttribute("feiletternavn", feiletternavn);
        request.getSession().setAttribute("feilmobil", feilmobil);
    }

    private void setUpCookiesTilRequest(HttpServletRequest request) {
        String fornavn = CookiesUtil.getCookieValue(request,"fornavn");
        String etternavn = CookiesUtil.getCookieValue(request,"etternavn");
        String mobil = CookiesUtil.getCookieValue(request,"mobil");
        request.getSession().setAttribute("fornavn", fornavn);
        request.getSession().setAttribute("etternavn", etternavn);
        request.getSession().setAttribute("mobil", mobil);
    }
}
