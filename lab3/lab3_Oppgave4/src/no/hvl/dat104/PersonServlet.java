package no.hvl.dat104;

import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Peder on 06.09.2017.
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String verdi1 = URLEncoder.encode(request.getParameter("fornavn"), "ISO-8859-1");
        String verdi2 = URLEncoder.encode(request.getParameter("etternavn"), "ISO-8859-1");
        String besok = finnCookie(request, "fornavn", "nei");
        if(besok.equals("nei")){
            lagCookie("fornavn", verdi1, response);
            lagCookie("etternavn", verdi2, response);
        }
        response.sendRedirect("/person");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String besok = finnCookie(request, "fornavn", "nei");
        boolean autofil;
        if(besok.equals("nei")) {
            request.setAttribute("autofil", false);
        }else {
            String fornavn = finnCookie(request, "fornavn", "fornavn");
            String etternavn = finnCookie(request, "etternavn", "etternavn");
            request.getSession().setAttribute("fornavn", fornavn);
            request.getSession().setAttribute("etternavn", etternavn);
            request.getSession().setAttribute("autofil", true);
        }
        request.getRequestDispatcher("person.jsp").forward(request,response);
    }
    public static void lagCookie(String navn, String verdi, HttpServletResponse response){
        Cookie cookie = new Cookie(navn.toString(), verdi);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }
    public static String finnCookie(HttpServletRequest request, String navn, String defaultVerdi) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        String funnetCookie = null;
        if (cookies != null){
            for(Cookie k : cookies) {
                if (navn.equals(k.getName())) {
                    funnetCookie = URLDecoder.decode(k.getValue(), "UTF-8");
                    return funnetCookie;
                }
            }
        }
        return defaultVerdi;
    }
}
