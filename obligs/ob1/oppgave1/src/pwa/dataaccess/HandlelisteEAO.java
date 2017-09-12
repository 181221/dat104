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

    public Bruker finnBruker(Integer brukernavn) {
        Bruker b = em.find(Bruker.class,brukernavn);
        return b;
    }
    public Bruker finnBrukerPaaNavn(String navn) {
        return (Bruker) em.createNamedQuery("Bruker.finnPaaNavn").setParameter("brukernavn",navn).getSingleResult();
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
