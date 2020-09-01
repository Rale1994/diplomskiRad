/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rados
 */
public class Sudjenje extends OpstiDomenskiObjkat implements Serializable {

    private String sudjenjeID;
    private Date datum;
    private int duzinaTrajanja;
    private PredmetSudjenja predmetSudjenja;
    private Advokat advokat;
    private Klijent klijent;

    public Sudjenje() {
    }

    public Sudjenje(String sudjenjeID, Date datum, int duzinaTrajanja, PredmetSudjenja predmetSudjenja, Advokat advokat, Klijent klijent) {
        this.sudjenjeID = sudjenjeID;
        this.datum = datum;
        this.duzinaTrajanja = duzinaTrajanja;
        this.predmetSudjenja = predmetSudjenja;
        this.advokat = advokat;
        this.klijent = klijent;
    }

   

    public PredmetSudjenja getPredmetSudjenja() {
        return predmetSudjenja;
    }

    public void setPredmetSudjenja(PredmetSudjenja predmetSudjenja) {
        this.predmetSudjenja = predmetSudjenja;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public String getSudjenjeID() {
        return sudjenjeID;
    }

    public void setSudjenjeID(String sudjenjeID) {
        this.sudjenjeID = sudjenjeID;
    }

    

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(int duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    @Override
    public String vratiImeTabele() {
        return "sudjenje";
    }

    @Override
    public String vratiParametre() {
        SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
        String datums=sdf.format(datum);
        return String.format("'%s', '%s', '%d', '%s', '%s', '%s'", sudjenjeID, datums, duzinaTrajanja, predmetSudjenja.getPredmetSudjenjaID(), advokat.getAdvokatID(), klijent.getKlijentID());
    }

    @Override
    public String vratiVrednostPK() {
        return sudjenjeID;
    }

    @Override
    public String vratiPk() {
        return "sudjenjeID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
