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
import java.util.List;

@Stateless
public class HandlelisteEAO {
    @PersistenceContext(name = "handlelistePersistenceUnit")
    private EntityManager em;

    public List<Vare> visAlleVarerTilBruker(){
        List<Vare> varer = em.createNamedQuery("Vare.visKurv").getResultList();

        return varer;
    }

    public List<Vare> visAlleVarer(){
       List<Vare> varer = em.createNamedQuery("Vare.visAlle").getResultList();
       return varer;
    }
    public void leggTilVare(Vare v){

        em.persist(v);
    }
    public Vare finnVare(String id) {
        return em.find(Vare.class, id);
    }
    public void slettVare(String id) {
        em.remove(em.find(Vare.class, id));
    }


    public Boolean leggTilBruker(String brukernavn, String passord) {
        Bruker funnet = finnBrukerPaaNavn(brukernavn);
        if(funnet == null){
            Bruker ny = new Bruker();
            Kurv nyKurv = new Kurv();
            nyKurv.setBeskrivelse(brukernavn + " Sin handlekurv");
            ny.setBrukernavn(brukernavn);
            ny.setPassord(passord);
            em.persist(ny);
            nyKurv.setBruker(ny);
            em.persist(nyKurv);
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
