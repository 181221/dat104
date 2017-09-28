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
        char[] alfabet = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();
        String passord = "";
        for (int i = 0; i < 5; i ++) {
            int plass =(int) (Math.random()*alfabet.length);
            passord += alfabet[plass];
        }
        return passord;
    }
    public static void oppdaterNyttPassord(HttpServletRequest request, String passord ,BrukerEAO brukerEAO) throws NoSuchAlgorithmException{
        Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
        String hashetPassord = SHA.SHA1Hash(passord);
        b.setPassord(hashetPassord);
        brukerEAO.oppdaterBruker(b);
    }
    public static void oppdaterNyttPassordUtenAAVeareInnlogget(Bruker bruker, String passord, BrukerEAO brukerEAO) throws NoSuchAlgorithmException{
        String hashetPassord = SHA.SHA1Hash(passord);
        bruker.setPassord(hashetPassord);
        brukerEAO.oppdaterBruker(bruker);
    }
}
