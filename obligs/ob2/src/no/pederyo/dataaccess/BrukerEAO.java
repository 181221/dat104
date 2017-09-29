package no.pederyo.dataaccess;

import no.pederyo.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<Bruker> finnAlleBrukere() {
        Query b = em.createQuery("SELECT b FROM Bruker b WHERE b.erKasserer = FALSE ORDER BY b.fornavn, b.etternavn");
        return b.getResultList();
    }

}
