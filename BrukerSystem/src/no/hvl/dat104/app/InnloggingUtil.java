package no.hvl.dat104.app;
import no.hvl.dat104.model.Bruker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Peder on 24.09.2017.
 */
public class InnloggingUtil {
    /**
     * @param brukernavn
     * @param passord
     * @return true om brukernavn og passord ikke er null og brukernavn < 20 og passord < 200
     */
    public static boolean isGyldigBrukernavn(String brukernavn, String passord) {
        return ValidatorUtil.isValidUsername(brukernavn) && ValidatorUtil.isValidPassword(passord);
    }
    public static boolean isGyldigBrukernavn(String brukernavn, String passord, String email) {
        return ValidatorUtil.isValidUsername(brukernavn) && ValidatorUtil.isValidPassword(passord) && ValidatorUtil.isValidEmail(email);
    }
    /**
     * Sjekker om bruker er innlogget
     * @param request
     * @return
     */
    public static boolean isInnlogget(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("currentUser") != null);
    }
    public static String isInnloggetSom(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return isInnlogget(request) ?
                (String) session.getAttribute("currentUser") : null;
    }
    /**
     * Logger inn brukeren, lagrer brukeren i sesjonen som currentUser-
     * Oppretter en flash - Velkommen tilbake
     * @param request lagrer en ny sesjon
     * @param b brukeren
     */
    public static void loggInnSom(HttpServletRequest request, Bruker b) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setAttribute("currentUser", b);
        FlashUtil.Flash(request, "Success", "Velkommen tilbake!");
    }

    /**
     * Logger inn brukeren, lagrer brukeren i sesjonen som currentUser.
     * Oppretter en flash - Velkommen tilbake!
     * @param request
     * @param b Bruker
     * @param init parameter fra xml fil
     */
    public static void loggInnSom(HttpServletRequest request, Bruker b, String init) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setMaxInactiveInterval(Integer.parseInt(init));
        sesjon.setAttribute("currentUser", b);
        FlashUtil.Flash(request, "Success", "Velkommen tilbake!");
    }
    /**
     * Looger ut og lager en flash - Logget deg ut!!
     * @param request
     */
    public static void loggUt(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        FlashUtil.Flash(request, "Success" ,"Logget Deg Ut!!");
    }
}
