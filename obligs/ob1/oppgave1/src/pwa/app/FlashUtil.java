package pwa.app;

import pwa.model.Bruker;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Peder on 13.09.2017.
 */
public class FlashUtil {
    public static String message;

    public static void loggetInn(HttpServletRequest request, String Melding, String brukernavn) {
        message = "Velkommen: "+ brukernavn;
        String flash = "Success";
        String melding = "Velkommen: " + brukernavn;
        request.getSession().setAttribute("melding", melding);
        request.getSession().setAttribute("flash", flash);
    }
    public static void UgyldigBruker(HttpServletRequest request) {
        message = "Ugyldig Brukernavn eller Passord";
        String flash = "Error";
        request.getSession().setAttribute("flash", flash);
    }
    public static void loggetUt(HttpServletRequest request) {
        message = "Logget Deg Ut!!";
        String flash = "Success";
        request.getSession().setAttribute("flash", flash);
    }
    public static void registrertBruker(HttpServletRequest request) {
        message = "Velkommen til din handleliste";
        String flash = "Success";
        request.getSession().setAttribute("flash", flash);
    }
    public static void UgylidRegistertBruker(HttpServletRequest request) {
        message = "UGYLDIG INPUT";
        String flash = "Error";
        request.getSession().setAttribute("flash", flash);
    }
}
