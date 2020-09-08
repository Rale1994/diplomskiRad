/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class Klijent extends OpstiDomenskiObjkat implements Serializable {

    private int klijentID;
    private String jmbg;
    private String ime;
    private String prezime;
    private String ulica;
    private String broj;
    private String kontaktTelefon;
    private Prebivaliste prebivaliste;
    private Advokat advokat;

    public Klijent() {
    }

    public Klijent(int klijentID, String jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, Prebivaliste prebivaliste, Advokat advokat) {
        this.klijentID = klijentID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.kontaktTelefon = kontaktTelefon;
        this.prebivaliste = prebivaliste;
        this.advokat = advokat;
    }

    public Klijent(String jmbg, String ime, String prezime, String ulica, String broj, String kontaktTelefon, Prebivaliste prebivaliste, Advokat advokat) {

        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.broj = broj;
        this.kontaktTelefon = kontaktTelefon;
        this.prebivaliste = prebivaliste;
        this.advokat = advokat;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
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

    @Override
    public String vratiImeTabele() {
        return "klijent";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d','%s', '%s', '%s', '%s', '%s', '%s', '%d','%d'", klijentID, jmbg, ime, prezime, ulica, broj, kontaktTelefon, prebivaliste.getPrebivalisteID(), advokat.getAdvokatID());
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

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> klijenti = new ArrayList<>();
        try {

            while (rs.next()) {
                int klijentId = rs.getInt("KlijentID");
                String jmbg = rs.getString("JMBG");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                String telefon = rs.getString("KontaktTelefon");

                Prebivaliste prebivaliste = new Prebivaliste();
                prebivaliste.setPrebivalisteID(rs.getInt("PrebivalisteID"));

                Advokat advokat = new Advokat();
                advokat.setAdvokatID(rs.getInt("AdvokatID"));

                Klijent klijent = new Klijent(klijentId, jmbg, ime, prezime, ulica, broj, telefon, prebivaliste, advokat);
                klijenti.add(klijent);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klijenti;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        return true;
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekte(ResultSet rs) {
        Klijent klijent = null;
        try {
            while (rs.next()) {
                int klijentId = rs.getInt("KlijentID");
                String jmbg = rs.getString("JMBG");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                String telefon = rs.getString("KontaktTelefon");

                Prebivaliste prebivaliste = new Prebivaliste();
                prebivaliste.setPrebivalisteID(rs.getInt("PrebivalisteID"));

                Advokat advokat = new Advokat();
                advokat.setAdvokatID(rs.getInt("AdvokatID"));

                klijent = new Klijent(klijentId, jmbg, ime, prezime, ulica, broj, telefon, prebivaliste, advokat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klijent;
    }
}
