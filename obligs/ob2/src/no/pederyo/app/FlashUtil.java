package no.pederyo.app;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Peder on 13.09.2017.
 */
public class FlashUtil {
    /**
     * Oppretter en flash melding.
     * @param request
     * @param flash  Error eller Success
     * @param melding Melding som skal vises til bruker.
     */
    public static void Flash(HttpServletRequest request, String flash, String melding){
            request.getSession().setAttribute("melding", melding);
            request.getSession().setAttribute("flash", flash);
    }

}
