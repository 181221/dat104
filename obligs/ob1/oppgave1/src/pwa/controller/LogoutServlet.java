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

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(InnloggingUtil.isInnlogget(request)) {
            InnloggingUtil.loggUt(request);
        }else {
            FlashUtil.message = "";
        }
        response.sendRedirect("/login?message=" + URLEncoder.encode(FlashUtil.message, "UTF-8"));
    }
}
