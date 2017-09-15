package pwa.dataaccess;

import pwa.model.Bruker;
import pwa.model.Kurv;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

/**
 * Created by Peder on 14.09.2017.
 */
@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "handlelistePersistenceUnit")
    private EntityManager em;

    public Boolean leggTilBruker(String brukernavn, String passord) {
        Bruker funnet = finnBrukerPaaNavn(brukernavn);
        if(funnet == null){
            Bruker ny = new Bruker();
            ny.setBrukernavn(brukernavn);
            ny.setPassord(passord);
            ny.getKurv().setBeskrivelse(brukernavn + " Sin handlekurv" );
            em.persist(ny);
        }
        return funnet == null;
    }

    public Bruker finnBrukerPaaNavn(String navn) {
        List<Bruker> bruker = em.createNamedQuery("Bruker.finnPaaNavn").setParameter("brukernavn",navn).getResultList();
        if(bruker.isEmpty()){
            return null;
        }
        return bruker.get(0);
    }


}
