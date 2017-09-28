package no.pederyo.dataaccess;

import no.pederyo.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Peder on 27.09.2017.
 */
@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "meldpaatilfest")
    private EntityManager em;

    public void leggTilBruker(Bruker b) {
        em.persist(b);
    }

    public Bruker finnBruker(String id) {
        return em.find(Bruker.class, id);
    }

}
