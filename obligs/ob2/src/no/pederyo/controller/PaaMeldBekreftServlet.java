package no.pederyo.controller;

import no.pederyo.app.CookiesUtil;
import no.pederyo.app.FlashUtil;
import no.pederyo.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.app.FlashUtil.Flash;
import static no.pederyo.controller.UrlMappings.PAAMELDING_URL;

/**
 * Created by Peder on 27.09.2017.
 */
@WebServlet(name = "paamelddingsbekreftelse", urlPatterns = UrlMappings.PAAMELDINGSBEKREFTELSE_URL)
public class PaaMeldBekreftServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)){
            boolean b = (boolean)request.getSession().getAttribute("riktig");
            if(b){
                request.getRequestDispatcher("WEB-INF/paameldbekreft.jsp").forward(request,response);
            }else {
                Flash(request, "Error", "Du kan ikke gjøre det!");
                response.sendRedirect(PAAMELDING_URL);
            }
        }else {
            response.sendRedirect(PAAMELDING_URL);
        }


    }
}
