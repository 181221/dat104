import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peder on 03.09.2017.
 */
@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String navn = request.getParameter("navn");
            String localen = request.getParameter("radio1");
            request.setAttribute("localen", localen);
            navn = StringEscapeUtils.escapeHtml4(navn);
            request.setAttribute("navn", navn);
            request.getRequestDispatcher("lang.jsp").forward(request, response);
    }
}
