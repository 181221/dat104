package lph.dataaccess;

import lph.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Peder on 06.09.2017.
 */
@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public void leggTilBruker(Bruker b) {
        em.persist(b);
    }
    public Bruker finnBruker(String id) {
        return em.find(Bruker.class, id);
    }
    public void oppdaterBruker(Bruker b){
        em.merge(b);
    }
    public void slettBruker(Bruker id) {
        em.remove(em.find(Bruker.class, id));
    }
}
