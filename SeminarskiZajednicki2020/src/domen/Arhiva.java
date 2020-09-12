/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rados
 */
public class Arhiva extends OpstiDomenskiObjkat implements Serializable {

    private int arhivaID;
    private Sertifikat sertifikatID;
    private Advokat advokat;
    private Date datumDobijanjaSertifikata;

    public Arhiva() {
    }

    public Arhiva(int arhivaID, Sertifikat sertifikatID, Advokat advokat, Date datumDobijanjaSertifikata) {
        this.arhivaID = arhivaID;
        this.sertifikatID = sertifikatID;
        this.advokat = advokat;
        this.datumDobijanjaSertifikata = datumDobijanjaSertifikata;
    }

   

    public Date getDatumDobijanjaSertifikata() {
        return datumDobijanjaSertifikata;
    }

    public void setDatumDobijanjaSertifikata(Date datumDobijanjaSertifikata) {
        this.datumDobijanjaSertifikata = datumDobijanjaSertifikata;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public Sertifikat getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(Sertifikat sertifikatID) {
        this.sertifikatID = sertifikatID;
    }

  

    public int getArhivaID() {
        return arhivaID;
    }

    public void setArhivaID(int arhivaID) {
        this.arhivaID = arhivaID;
    }

    @Override
    public String vratiImeTabele() {
        return "arhiva";
    }

    @Override
    public String vratiParametre() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datum = sdf.format(datumDobijanjaSertifikata);
        return String.format("'%d','%d','%d','%s'", advokat.getAdvokatID(), sertifikatID, arhivaID, datum);
    }

    @Override
    public int vratiVrednostPK() {
        return arhivaID;
    }

    @Override
    public String vratiPk() {
        return "arhiva";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public String alijas() {
        return "ar.";
    }

    @Override
    public String update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKriterijumPretrage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
