/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Rados
 */
public class Sudjenje {
    
    private Advokat advokat;
    private Klijent klijent;
    private int sudjenjeID;
    private Date datum;
    private int duzinaTrajanja;
    private PredmetSudjenja predmetSudjenja;

    public Sudjenje() {
    }

    public Sudjenje(Advokat advokat, Klijent klijent, int sudjenjeID, Date datum, int duzinaTrajanja, PredmetSudjenja predmetSudjenja) {
        this.advokat = advokat;
        this.klijent = klijent;
        this.sudjenjeID = sudjenjeID;
        this.datum = datum;
        this.duzinaTrajanja = duzinaTrajanja;
        this.predmetSudjenja = predmetSudjenja;
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

    public int getSudjenjeID() {
        return sudjenjeID;
    }

    public void setSudjenjeID(int sudjenjeID) {
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

}
