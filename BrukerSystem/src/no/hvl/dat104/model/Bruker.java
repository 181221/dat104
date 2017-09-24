package no.hvl.dat104.model;

import javax.persistence.*;

/**
 * Created by Peder on 24.09.2017.
 */
@Entity
@Table(name = "bruker", schema = "brukersystem")
@NamedQuery(name="Bruker.finnPaaNavn", query="SELECT b FROM Bruker b WHERE b.brukernavn = :brukernavn")
public class Bruker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bruker_id;

    @Column(name = "brukernavn")
    private String brukernavn;
    @Column(name = "passord")
    private String passord;
    @Column(name = "email")
    private String email;

    public Bruker() {
        this("","","");
    }

    public Bruker(String brukernavn, String passord, String email) {
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.email = email;
    }

    public Integer getBruker_id() {
        return bruker_id;
    }

    public void setBruker_id(Integer bruker_id) {
        this.bruker_id = bruker_id;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
