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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class Prebivaliste extends OpstiDomenskiObjkat implements Serializable {

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

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> ListaPrebivalista = new ArrayList<>();
        try {
            while (rs.next()) {
                prebivalisteID = rs.getInt("PrebivalisteID");
                String postanskiBroj = rs.getString("PostanskiBroj");
                String naziv = rs.getString("Naziv");

                Prebivaliste prebivaliste = new Prebivaliste(prebivalisteID, postanskiBroj, naziv);
                ListaPrebivalista.add(prebivaliste);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prebivaliste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListaPrebivalista;
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public String vratiKriterijumPretrage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereUslov(String pretraga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
