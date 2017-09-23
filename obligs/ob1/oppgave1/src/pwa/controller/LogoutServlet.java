package pwa.controller;

import pwa.app.FlashUtil;
import pwa.app.InnloggingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

import static pwa.controller.UrlMappings.LOGIN_URL;

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet()
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            InnloggingUtil.loggUt(request);
        }
        response.sendRedirect(LOGIN_URL);
    }
}
