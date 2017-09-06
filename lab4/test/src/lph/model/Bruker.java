package lph.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Peder on 06.09.2017.
 */
@Entity
public class Bruker {
    private String navn;
    private String etternavn;

    @Id
    @Column(name = "navn")
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Basic
    @Column(name = "etternavn")
    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bruker bruker = (Bruker) o;

        if (navn != null ? !navn.equals(bruker.navn) : bruker.navn != null) return false;
        if (etternavn != null ? !etternavn.equals(bruker.etternavn) : bruker.etternavn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = navn != null ? navn.hashCode() : 0;
        result = 31 * result + (etternavn != null ? etternavn.hashCode() : 0);
        return result;
    }
}
