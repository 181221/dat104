package no.hvl.dat104.app;

import no.hvl.dat104.dataaccess.BrukerEAO;
import no.hvl.dat104.model.Bruker;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Peder on 24.09.2017.
 */
public class GenererPassord {

    public static String nyttPassord() {
        return "heisanndu";
    }
    public static void oppdaterNyttPassord(HttpServletRequest request, String passord ,BrukerEAO brukerEAO) throws NoSuchAlgorithmException{
        Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
        String hashetPassord = SHA.SHA1Hash(passord);
        b.setPassord(hashetPassord);
        brukerEAO.oppdaterBruker(b);
    }
}
