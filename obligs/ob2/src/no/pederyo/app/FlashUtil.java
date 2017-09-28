package no.pederyo.app;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peder on 13.09.2017.
 */
public class FlashUtil {
    List<String> meldinger;
    public FlashUtil() {
        meldinger = new ArrayList<>(3);
    }
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

    public List<String> getMeldinger() {
        return meldinger;
    }

    public void setMeldinger(List<String> meldinger) {
        this.meldinger = meldinger;
    }
}
