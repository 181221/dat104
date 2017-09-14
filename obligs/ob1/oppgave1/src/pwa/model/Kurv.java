
package pwa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Peder on 12.09.2017.
 */

@Entity
@Table(name = "kurv", schema = "handleliste")
public class Kurv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kurv_id;


    @Transient
    private List<Vare> varer;

    private String beskrivelse;

    public Kurv(){
        this(null,"");
        varer = new ArrayList<>();
    }

    public Kurv(Bruker bruker, String beskrivelse) {
        this.bruker = bruker;
        this.beskrivelse = beskrivelse;
        varer = new ArrayList<>();
    }
    public void leggTilVare(){

    }
    public List<Vare> getVarer() {
        return varer;
    }

    public void setVarer(List<Vare> varer) {
        this.varer = varer;
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

