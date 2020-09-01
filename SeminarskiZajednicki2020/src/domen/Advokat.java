/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Rados
 */
public class Advokat extends OpstiDomenskiObjkat implements Serializable {

    private String advokatID;
    private int jmbg;
    private String ime;
    private String prezime;
    private String ulica;
    private String broj;
    private String kontaktTelefon;
    private String korisnickoIme;
    private String lozinka;
    private Prebivaliste prebivaliste;
    private Arhiva arhiva;

    public Advokat() {
    }

    public Advokat(String advokatID, int jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, String korisnickoIme, String lozinka, Prebivaliste prebivaliste, Arhiva arhiva) {
        this.advokatID = advokatID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.kontaktTelefon = kontaktTelefon;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.prebivaliste = prebivaliste;
        this.arhiva = arhiva;
    }

    public Arhiva getArhiva() {
        return arhiva;
    }

    public void setArhiva(Arhiva arhiva) {
        this.arhiva = arhiva;
    }

  

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Prebivaliste getPrebivaliste() {
        return prebivaliste;
    }

    public void setPrebivaliste(Prebivaliste prebivaliste) {
        this.prebivaliste = prebivaliste;
    }

    @Override
    public String vratiImeTabele() {
        return "advokat";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s','%d','%s','%s','%s','%s','%s','%s','%s','%s','%s'", advokatID, jmbg, ime, prezime, ulica, broj, kontaktTelefon, korisnickoIme, lozinka, prebivaliste.getPrebivalisteID(),arhiva.getArhivaID());
    }

    @Override
    public String vratiPk() {
        return "advokatID";
    }

    @Override
    public String vratiVrednostPK() {
        return advokatID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAdvokatID() {
        return advokatID;
    }

    public void setAdvokatID(String advokatID) {
        this.advokatID = advokatID;
    }

}
