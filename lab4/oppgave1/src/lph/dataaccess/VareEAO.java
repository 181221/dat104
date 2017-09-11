package lph.dataaccess;

import lph.model.Vare;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Peder on 06.09.2017.
 */
@Stateless
public class VareEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public void leggTilVare(Vare b) {
        em.persist(b);
    }
    public Vare finnVare(String id) {
        return em.find(Vare.class, id);
    }
    public void oppdaterVare(Vare b){
        em.merge(b);
    }
    public void slettVare(Vare id) {
        em.remove(em.find(Vare.class, id.getItem()));
    }
    public List<Vare> alleVarer() {
        TypedQuery<Vare> query = em.createQuery("SELECT v FROM Vare v", Vare.class);
        return query.getResultList();
    }
}
