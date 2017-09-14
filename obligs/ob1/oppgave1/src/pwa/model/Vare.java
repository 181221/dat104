package pwa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vare", schema = "handleliste")
@NamedQueries({
        @NamedQuery(name = "Vare.visAlle", query = "SELECT v FROM Vare v"),
        @NamedQuery(name = "Vare.visKurv", query = "SELECT v.navn FROM Vare v JOIN Kurv k ON v.kurv.kurv_id = k.kurv_id JOIN Bruker b ON k.kurv_id = b.bruker_id WHERE b.bruker_id = :id")
})
public class Vare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vare_id;

    @Column(name = "navn")
    private String navn;
    @ManyToOne
    @JoinColumn(name = "kurv_id", referencedColumnName = "kurv_id")
    private Kurv kurv;


    public Vare() {
        this("");
    }

    public Vare(String navn) {
        this.navn = navn;
    }

    public Kurv getKurv() {
        return kurv;
    }

    public void setKurv(Kurv kurv) {
        this.kurv = kurv;
    }

    public Integer getVare_id() {
        return vare_id;
    }

    public void setVare_id(Integer vare_id) {
        this.vare_id = vare_id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
