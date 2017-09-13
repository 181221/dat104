/*
package pwa.model;

import javax.persistence.*;

*/
/**
 * Created by Peder on 12.09.2017.
 *//*

@Entity
@Table(name = "kurv", schema = "handleliste")
public class Kurv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kurv_id;

    @JoinColumn(name = "bruker_id", referencedColumnName = "bruker_id")
    private Bruker bruker;

    @Basic
    private String beskrivelse;

    public Kurv(){
        this(null,"");
    }

    public Kurv(Bruker bruker, String beskrivelse) {
        this.bruker = bruker;
        this.beskrivelse = beskrivelse;
    }

    public Integer getKurv_id() {
        return kurv_id;
    }

    public void setKurv_id(Integer kurv_id) {
        this.kurv_id = kurv_id;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
*/
