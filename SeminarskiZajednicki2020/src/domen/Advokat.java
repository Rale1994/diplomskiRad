/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Rados
 */
public class Advokat extends OpstiDomenskiObjkat{
    
    private int advokatID;
    private String jmbg;
    private String ime;
    private String prezime;
    private String ulica;
    private String broj;
    private String kontaktTelefon;
    private String korisnickoIme;
    private String lozinka;
    private Prebivaliste prebivaliste;
    private Sertifikat sertifikat;

    public Advokat() {
    }

    public Advokat(int advokatID, String jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, String korisnickoIme, String lozinka, Prebivaliste prebivaliste, Sertifikat sertifikat) {
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
        this.sertifikat = sertifikat;
    }

    public Sertifikat getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(Sertifikat sertifikat) {
        this.sertifikat = sertifikat;
    }

    public int getAdvokatID() {
        return advokatID;
    }

    public void setAdvokatID(int advokatID) {
        this.advokatID = advokatID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
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
        return String.format("'%d','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'", advokatID,jmbg,ime, prezime, ulica, broj,kontaktTelefon,korisnickoIme,lozinka, prebivaliste.getPrebivalisteID(), sertifikat.getSertifikatID());
    }

    @Override
    public int vratiVrednostPK() {
        return advokatID;
    }
    

}
