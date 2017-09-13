package pwa.dataaccess;

/**
 * Created by Peder on 06.09.2017.
 */

import pwa.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class HandlelisteEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public void leggTilBruker(String brukernavn, String passord) {
        Bruker ny = new Bruker();
        ny.setBrukernavn(brukernavn);
        ny.setPassord(passord);
        em.persist(ny);
    }

    public String finnBrukerPaaNavn(String navn) {
        Bruker b = null;
        b = (Bruker) em.createNamedQuery("Bruker.finnPaaNavn").setParameter("brukernavn",navn).getSingleResult();
        if(b != null){
            return b.getPassord();
        }
        return null;
    }
    /*public void leggTil(Klasse b) {
        em.persist(b);
    }

    public void oppdaterKlasse(Klasse b){
        em.merge(b);
    }
    public void slettKlasse(Klasse id) {
        em.remove(em.find(Bruker.class, id));
    }*/
}
