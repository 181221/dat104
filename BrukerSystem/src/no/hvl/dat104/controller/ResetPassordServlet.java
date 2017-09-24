package no.hvl.dat104.controller;

import no.hvl.dat104.app.FlashUtil;
import no.hvl.dat104.app.InnloggingUtil;
import no.hvl.dat104.util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */

public class ResetPassordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MailUtil.setUpMail(request,"peder.wiig@gmail.com","Wpoxns147");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            request.getRequestDispatcher("WEB-INF/reset.jsp").forward(request, response);
        }else {
            FlashUtil.Flash(request,"Error", "Du må være innlogget!");
            response.sendRedirect(LOGIN_URL);
        }
    }
}
