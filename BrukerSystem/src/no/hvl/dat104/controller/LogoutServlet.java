package no.hvl.dat104.controller;

import no.hvl.dat104.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 24.09.2017.
 */
public class LogoutServlet extends HttpServlet {
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          if(InnloggingUtil.isInnlogget(request)) {
              InnloggingUtil.loggUt(request);
          }
          response.sendRedirect(LOGIN_URL);
      }
}
