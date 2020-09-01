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
public class Arhiva extends OpstiDomenskiObjkat implements Serializable{

    private Advokat advokat;
    private String sertifikatID;
    private String arhivaID;
    private Date datumDobijanjaSertifikata;

    public Arhiva() {
    }

    public Arhiva(Advokat advokat, String sertifikatID, String arhivaID, Date datumDobijanjaSertifikata) {
        this.advokat = advokat;
        this.sertifikatID = sertifikatID;
        this.arhivaID = arhivaID;
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

    public String getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(String sertifikatID) {
        this.sertifikatID = sertifikatID;
    }

    

    public String getArhivaID() {
        return arhivaID;
    }

    public void setArhivaID(String arhivaID) {
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
        return String.format("'%s','%s','%s','%s'", advokat.getAdvokatID(), sertifikatID, arhivaID, datum);
    }

    @Override
    public String vratiVrednostPK() {
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

}
