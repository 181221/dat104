package no.hvl.dat104.controller;

import no.hvl.dat104.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 24.09.2017.
 */

public class SecretServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            request.getRequestDispatcher("WEB-INF/secret.jsp").forward(request, response);
        }else {
            response.sendRedirect(UrlMappings.LOGIN_URL);
        }
    }
}
