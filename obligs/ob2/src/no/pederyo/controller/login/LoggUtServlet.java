package no.pederyo.controller.login;

import no.pederyo.utils.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 29.09.2017.
 */

public class LoggUtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InnloggingUtil.loggUt(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InnloggingUtil.loggUt(request);
        request.getRequestDispatcher("WEB-INF/loggut.jsp").forward(request,response);
    }
}
