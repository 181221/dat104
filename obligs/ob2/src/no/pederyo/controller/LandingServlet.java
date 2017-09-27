package no.pederyo.controller;

import no.hvl.dat104.app.CookiesUtil;
import no.pederyo.app.ValidatorUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelding", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cookie> cookies = sjekkPersonOpplysninger(request);
        if(sjekkCookies(cookies)) {
            // det er verdier i alle cookiesene nå må Eg sjekke fnavn etternavn og mobil.
        }else {
            System.out.println("du har et par feil her");
        }
        //hentPersonOpplysninger(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
    private boolean sjekkCookies(List<Cookie> cookies) {
        for(int i = 0; i < cookies.size(); i ++) {
            if(!(ValidatorUtil.isNotNull0(cookies.get(i).getValue()))) {
                System.out.println("feil her:" + cookies.get(i).getValue());
                return false;
            }else {
                ValidatorUtil.escapeHtml(cookies.get(i).getValue());
            }
        }
        return true;
    }
    private List<Cookie> sjekkPersonOpplysninger(HttpServletRequest request) {
        Enumeration<String> k = request.getParameterNames();
        List<Cookie> cookies = new ArrayList<>();
        while (k.hasMoreElements()){
            String param = k.nextElement();
            Cookie ny = new Cookie(param,request.getParameter(param));
            cookies.add(ny);
        }
        return cookies;
    }
}
