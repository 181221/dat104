package lph.dataaccess;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Peder on 06.09.2017.
 */
/*@Stateless
//public class KlasseEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;
*//*
    public void leggTilKlasse(Klasse b) {
        em.persist(b);
    }
    public Klasse finnBruker(String id) {
        return em.find(Klasse.class, id);
    }
    public void oppdaterKlasse(Klasse b){
        em.merge(b);
    }
    public void slettKlasse(Klasse id) {
        em.remove(em.find(Bruker.class, id));
    }*//*
}*/
