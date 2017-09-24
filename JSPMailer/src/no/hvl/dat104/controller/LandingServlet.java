package no.hvl.dat104.controller;
import no.hvl.dat104.app.MailUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static no.hvl.dat104.controller.UrlMappings.RESULT_URL;

@WebServlet
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MailUtil.setUpMail(request);
        response.sendRedirect(RESULT_URL);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
}
