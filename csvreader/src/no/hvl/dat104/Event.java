package no.hvl.dat104;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Peder on 12.11.2017.
 */
public class Event {
    private String name;
    private String beskrivelse;
    private Timestamp tidFra;
    private Timestamp tidTil;
    private String sted;
    private String aktivitet;

    public Event(String name, String beskrivelse, Timestamp tidFra, Timestamp tidTil, String sted, String aktivitet) {
        this.name = name;
        this.beskrivelse = beskrivelse;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
        this.sted = sted;
        this.aktivitet = aktivitet;
    }

    public String getAktivitet() {
        return aktivitet;
    }

    public void setAktivitet(String aktivitet) {
        this.aktivitet = aktivitet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Timestamp getTidFra() {
        return tidFra;
    }

    public void setTidFra(Timestamp tidFra) {
        this.tidFra = tidFra;
    }

    public Timestamp getTidTil() {
        return tidTil;
    }

    public void setTidTil(Timestamp tidTil) {
        this.tidTil = tidTil;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", tidFra=" + tidFra +
                ", tidTil=" + tidTil +
                ", sted='" + sted + '\'' +
                ", aktivitet='" + aktivitet + '\'' +
                '}';
    }
}
