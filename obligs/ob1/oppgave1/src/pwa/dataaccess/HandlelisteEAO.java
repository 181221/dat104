package pwa.dataaccess;

/**
 * Created by Peder on 06.09.2017.
 */

import pwa.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HandlelisteEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public Boolean leggTilBruker(String brukernavn, String passord) {
        Bruker funnet = finnBrukerPaaNavn(brukernavn);
        if(funnet == null){
            Bruker ny = new Bruker();
            ny.setBrukernavn(brukernavn);
            ny.setPassord(passord);
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
