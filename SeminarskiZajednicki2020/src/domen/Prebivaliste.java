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
public class Prebivaliste extends OpstiDomenskiObjkat implements Serializable{

    private int prebivalisteID;
    private String postanskiBroj;
    private String naziv;

    public Prebivaliste() {
    }

    public Prebivaliste(int prebivalisteID, String postanskiBroj, String naziv) {
        this.prebivalisteID = prebivalisteID;
        this.postanskiBroj = postanskiBroj;
        this.naziv = naziv;
    }

    

  

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPrebivalisteID() {
        return prebivalisteID;
    }

    public void setPrebivalisteID(int prebivalisteID) {
        this.prebivalisteID = prebivalisteID;
    }

   

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }



    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeTabele() {
        return "prebivaliste";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d', '%s', '%s'", prebivalisteID, postanskiBroj, naziv);
    }

    @Override
    public int vratiVrednostPK() {
        return prebivalisteID;
    }

    @Override
    public String vratiPk() {
        return "prebivalisteID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
