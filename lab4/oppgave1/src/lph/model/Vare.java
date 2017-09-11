package lph.model;
import javax.persistence.*;

@Entity
public class Vare {
    @Id
    private String item;

    public String getItem() {
        return item;
    }
    public void setItem(String navn) {
        this.item = navn;
    }
}
