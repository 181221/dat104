package lph.controller;

import lph.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 11.09.2017.
 */
@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InnloggingUtil.loggUt(request);
        request.getRequestDispatcher("logut.jsp").forward(request,response);
    }

}
