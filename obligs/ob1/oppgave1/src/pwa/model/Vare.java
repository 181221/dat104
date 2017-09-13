package pwa.model;

import javax.persistence.*;



@Entity
@Table(name = "vare", schema = "handleliste")
@NamedQuery(name="Vare.visAlle", query="SELECT v FROM Vare v")
public class Vare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vare_id;

    @Column(name = "navn")
    private String navn;

    public Vare(){
        this("");
    }
    public Vare(String navn) {
        this.navn = navn;
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
