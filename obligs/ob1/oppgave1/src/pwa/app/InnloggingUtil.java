package pwa.app;

import pwa.dataaccess.HandlelisteEAO;
import pwa.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Peder on 13.09.2017.
 */
public class InnloggingUtil {

    //senere escape sql
    public static boolean isGyldigBrukernavn(String brukernavn, String passord) {
        return brukernavn != "" && passord != "";
    }

    public static boolean isInnlogget(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("loggedInUser") != null);
    }

    public static String isInnloggetSom(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return isInnlogget(request) ?
                (String) session.getAttribute("loggedInUser") : null;
    }

    public static void loggInnSom(HttpServletRequest request, Bruker b) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setMaxInactiveInterval(60);
        sesjon.setAttribute("currentUser", b);
        sesjon.setAttribute("loggedInUser", b.getBrukernavn());
        FlashUtil.Flash(request, "Success", "Velkommen tilbake!");
    }

    public static void loggUt(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        FlashUtil.loggetUt(request);
    }
}
