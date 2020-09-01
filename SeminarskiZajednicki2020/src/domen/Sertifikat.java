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
public class Sertifikat extends OpstiDomenskiObjkat implements Serializable {

    private String sertifikatID;
    private String nazivSertifikata;

    public Sertifikat() {
    }

    public Sertifikat(String sertifikatID, String nazivSertifikata) {
        this.sertifikatID = sertifikatID;
        this.nazivSertifikata = nazivSertifikata;
    }

  

    public String getNazivSertifikata() {
        return nazivSertifikata;
    }

    public void setNazivSertifikata(String nazivSertifikata) {
        this.nazivSertifikata = nazivSertifikata;
    }

    public String getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(String sertifikatID) {
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
        return String.format("'%s','%s'", sertifikatID, nazivSertifikata);
    }

    @Override
    public String vratiVrednostPK() {
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

}
