package no.hvl.dat104.app;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Peder on 24.09.2017.
 */
public class FlashUtil {
    /**
     * Oppretter en flash melding som skal vises i jsp.
     * @param request
     * @param flash Errror eller Success
     * @param melding f.eks feil brukernavn
     */
    public static void Flash(HttpServletRequest request, String flash, String melding){
        request.getSession().setAttribute("melding", melding);
        request.getSession().setAttribute("flash", flash);
    }
}
