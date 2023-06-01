package hu.nye.progkor.kvweb.data.model;

import java.util.Objects;

public class Kave {

    private Long id;

    private String marka;

    private String eredet;

    private String fajta;

    private String savassag;

    private String kiszereles;

    private Porkoles porkoles;

    public Kave(Long id, String marka, String eredet, String fajta, String savassag, String kiszereles, Porkoles porkoles) {
       this.id = id;
       this.marka = marka;
       this.eredet = eredet;
       this.fajta = fajta;
       this.savassag = savassag;
       this.kiszereles = kiszereles;
       this.porkoles = porkoles;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getEredet() {
        return eredet;
    }

    public void setEredet(String eredet) {
        this.eredet = eredet;
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    public String getSavassag() {
        return savassag;
    }

    public void setSavassag(String savassag) {
        this.savassag = savassag;
    }

    public String getKiszereles() {
        return kiszereles;
    }

    public void setKiszereles(String kiszereles) {
        this.kiszereles = kiszereles;
    }

    public Porkoles getPorkoles() {
        return porkoles;
    }

    public void setPorkoles(Porkoles porkoles) {
        this.porkoles = porkoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kave kave = (Kave) o;
        return Objects.equals(id, kave.id) && Objects.equals(marka, kave.marka) && Objects.equals(eredet, kave.eredet) && Objects.equals(fajta, kave.fajta) && Objects.equals(savassag, kave.savassag) && Objects.equals(kiszereles, kave.kiszereles) && porkoles == kave.porkoles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, eredet, fajta, savassag, kiszereles, porkoles);
    }

    @Override
    public String toString() {
        return "Kave{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", eredet='" + eredet + '\'' +
                ", fajta='" + fajta + '\'' +
                ", savassag='" + savassag + '\'' +
                ", kiszereles='" + kiszereles + '\'' +
                ", porkoles=" + porkoles +
                '}';
    }
}
