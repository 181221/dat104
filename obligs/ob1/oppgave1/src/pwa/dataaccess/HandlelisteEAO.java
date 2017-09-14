package pwa.dataaccess;

/**
 * Created by Peder on 06.09.2017.
 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import pwa.model.Bruker;
import pwa.model.Kurv;
import pwa.model.Vare;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class HandlelisteEAO {
    @PersistenceContext(name = "handlelistePersistenceUnit")
    private EntityManager em;

    public List<Vare> visAlleVarerTilBruker(Integer id) {
        TypedQuery<Vare> vare = em.createQuery("SELECT v.navn FROM Vare v WHERE v.kurv.kurv_id =: id", Vare.class).setParameter("id",id);
        return vare.getResultList();
    }

    /*public List<Vare> visAlleVarerTilBruker(Integer id){
        List<Vare> varer = em.createNamedQuery("Vare.visKurv").setParameter("id", id).getResultList();
        return varer;
    }*/

    /*public List<Vare> visAlleVarer(){
       List<Vare> varer = em.createNamedQuery("Vare.visAlle").getResultList();
       return varer;
    }*/
    public void leggTilVare(Vare v){
        em.persist(v);
    }
    public Vare finnVare(String id) {
        return em.find(Vare.class, id);
    }
    public void slettVare(String id) {
        em.remove(em.find(Vare.class, id));
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
