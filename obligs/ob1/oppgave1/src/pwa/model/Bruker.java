package pwa.model;

import javax.persistence.*;

/**
 * Created by Peder on 12.09.2017.
 */
@Entity
@Table(name = "bruker", schema = "handleliste")
@NamedQuery(name="Bruker.finnPaaNavn", query="SELECT b FROM Bruker b WHERE b.brukernavn = :brukernavn")
public class Bruker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bruker_id;

    @Column(name = "brukernavn")
    private String brukernavn;

    @Column(name = "passord")
    private String passord;

    public Bruker() {
        this("","");
    }
    public Bruker(String brukernavn, String passord) {
        this.brukernavn = brukernavn;
        this.passord = passord;
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
}
