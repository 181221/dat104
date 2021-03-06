package no.hvl.dat104.dataaccess;

import no.hvl.dat104.model.Bruker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Peder on 24.09.2017.
 */
@Stateless
public class BrukerEAO {
    @PersistenceContext(name = "BrukerSystem")
    private EntityManager em;

    public Bruker leggTil(String brukernavn, String passord, String email) {
        Bruker b = lagNyBruker(brukernavn, passord, email);
        em.persist(b);
        return b;
    }
    private Bruker lagNyBruker(String b, String p, String email) {
        Bruker ny = new Bruker();
        ny.setBrukernavn(b);
        ny.setPassord(p);
        ny.setEmail(email);
        return ny;
    }
    public Bruker finnBruker(String id) {
        return em.find(Bruker.class, id);
    }
    public void oppdaterBruker(Bruker b){
        em.merge(b);
    }
    public boolean sjekkOmBrukerErRegistrert(String brukernavn) {
        List<Bruker> bruker =  em.createQuery(
                "SELECT b FROM Bruker b WHERE b.brukernavn = :BrukerNavn")
                .setParameter("BrukerNavn", brukernavn)
                .setMaxResults(10)
                .getResultList();
        return bruker.isEmpty();
    }
    public Bruker finnBrukerPaaEmail(String email) {
        List<Bruker> bruker = em.createQuery("SELECT b FROM Bruker b WHERE b.email = :email").setParameter("email",email).getResultList();
        if(bruker.isEmpty()){
            return null;
        }
        return bruker.get(0);
    }
    public Bruker finnBrukerPaaNavn(String navn) {
        List<Bruker> bruker = em.createNamedQuery("Bruker.finnPaaNavn").setParameter("brukernavn",navn).getResultList();
        if(bruker.isEmpty()){
            return null;
        }
        return bruker.get(0);
    }

}
