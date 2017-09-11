package lph.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Peder on 11.09.2017.
 */
@Entity
public class Bruker {
    private int brukerId;
    private String brukernavn;

    @Id
    @Column(name = "bruker_id")
    public int getBrukerId() {
        return brukerId;
    }

    public void setBrukerId(int brukerId) {
        this.brukerId = brukerId;
    }

    @Basic
    @Column(name = "brukernavn")
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bruker bruker = (Bruker) o;

        if (brukerId != bruker.brukerId) return false;
        if (brukernavn != null ? !brukernavn.equals(bruker.brukernavn) : bruker.brukernavn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brukerId;
        result = 31 * result + (brukernavn != null ? brukernavn.hashCode() : 0);
        return result;
    }
}
