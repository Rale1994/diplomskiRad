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
public class Sertifikat extends OpstiDomenskiObjkat implements Serializable {

    private int sertifikatID;
    private String nazivSertifikata;

    public Sertifikat() {
    }

    public Sertifikat(int sertifikatID, String nazivSertifikata) {
        this.sertifikatID = sertifikatID;
        this.nazivSertifikata = nazivSertifikata;
    }

    public String getNazivSertifikata() {
        return nazivSertifikata;
    }

    public void setNazivSertifikata(String nazivSertifikata) {
        this.nazivSertifikata = nazivSertifikata;
    }

    public int getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(int sertifikatID) {
        this.sertifikatID = sertifikatID;
    }

    @Override
    public String toString() {
        return nazivSertifikata;
    }

    @Override
    public String vratiImeTabele() {
        return "sertifikat";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d','%s'", sertifikatID, nazivSertifikata);
    }

    @Override
    public int vratiVrednostPK() {
        return sertifikatID;
    }

    @Override
    public String vratiPk() {
        return "sertifikatID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> lisatSertifikata = new ArrayList<>();
        try {
            while (rs.next()) {
                try  {
                    int id = rs.getInt("SertifikatID");
                    String naziv = rs.getString("NazivSertifikata");

                    Sertifikat sertifikat = new Sertifikat(id, naziv);
                    lisatSertifikata.add(sertifikat);
                } catch (SQLException ex) {
                    Logger.getLogger(Sertifikat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sertifikat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisatSertifikata;
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String alijas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
