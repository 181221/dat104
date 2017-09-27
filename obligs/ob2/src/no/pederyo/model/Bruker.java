package no.pederyo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Peder on 27.09.2017.
 */
@Entity
@Table(name = "bruker", schema = "oblig2")
public class Bruker {
    @Id
    private String tlf;

    @Column(name = "kjonn")
    private String kjonn;

    @Column(name = "fornavn")
    private String fornavn;

    @Column(name = "etternavn")
    private String etternavn;

    @Column(name="er_kasserer")
    private Boolean erKasserer;

    @Column(name = "har_betalt")
    private Boolean harBetalt;

    public Bruker(){
        this("","","","",null,null);
    }

    public Bruker(String tlf, String kjonn, String fornavn, String etternavn, Boolean erKasserer, Boolean harBetalt) {
        this.tlf = tlf;
        this.kjonn = kjonn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.erKasserer = erKasserer;
        this.harBetalt = harBetalt;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Boolean getErKasserer() {
        return erKasserer;
    }

    public void setErKasserer(Boolean erKasserer) {
        this.erKasserer = erKasserer;
    }

    public Boolean getHarBetalt() {
        return harBetalt;
    }

    public void setHarBetalt(Boolean harBetalt) {
        this.harBetalt = harBetalt;
    }
}
