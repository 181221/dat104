package no.pederyo.utils;

import no.pederyo.model.Bruker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Peder on 13.09.2017.
 */
public class InnloggingUtil {
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
     * Logger inn Må ha en Brukerklasse no.pederyo.model.Bruker
     * @param request
     * @param b
     * @param init henter fra init parameter i xml.
     */
    public static void loggInnSom(HttpServletRequest request, Bruker b, String init) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setMaxInactiveInterval(Integer.parseInt(init));
        sesjon.setAttribute("currentUser", b);
    }
    /**
     * Logger inn med Bruker objectet.
     * Setter currentUser som brukeren
     * @param request
     * @param b
     */
    public static void loggInnSom(HttpServletRequest request, Bruker b) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setAttribute("currentUser", b);
    }
    /**
     * Logger inn med streng brukernavn.
     * currentUser er nå en streng.
     * @param request
     */
    public static boolean isInnLoggetSomKasserer(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("kasserer") != null);
    }
    public static void loggInnSomKasserer(HttpServletRequest request) {
        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setAttribute("kasserer", "kasserer");
    }
    /**
     * logger deg ut!
     * @param request
     */
    public static void loggUt(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
