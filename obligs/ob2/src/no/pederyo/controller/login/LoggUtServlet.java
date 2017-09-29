package no.pederyo.controller.login;

import no.pederyo.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.pederyo.controller.UrlMappings.LOGGUT;

/**
 * Created by Peder on 29.09.2017.
 */
@WebServlet(name = "LoggUtServlet", urlPatterns = LOGGUT)
public class LoggUtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InnloggingUtil.loggUt(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InnloggingUtil.loggUt(request);
        request.getRequestDispatcher("WEB-INF/loggut.jsp").forward(request,response);
    }
}
