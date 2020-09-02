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
public class Klijent extends OpstiDomenskiObjkat implements Serializable{

    private int klijentID;
    private int jmbg;
    private String ime;
    private String prezime;
    private String ulica;
    private String broj;
    private String kontaktTelefon;
    private Prebivaliste prebivaliste;

    public Klijent() {
    }

    public Klijent(int klijentID, int jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, Prebivaliste prebivaliste) {
        this.klijentID = klijentID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.kontaktTelefon = kontaktTelefon;
        this.prebivaliste = prebivaliste;
    }

  

  

  

    public Prebivaliste getPrebivaliste() {
        return prebivaliste;
    }

    public void setPrebivaliste(Prebivaliste prebivaliste) {
        this.prebivaliste = prebivaliste;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
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

    @Override
    public String vratiImeTabele() {
        return "klijent";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d','%d', '%s', '%s', '%s', '%s', '%s', '%d'", klijentID, jmbg, ime, prezime, ulica, broj, kontaktTelefon, prebivaliste.getPrebivalisteID());
    }

    @Override
    public int vratiVrednostPK() {
        return klijentID;
    }

    @Override
    public String vratiPk() {
        return "klijentID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
