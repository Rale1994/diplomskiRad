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
public class Arhiva {
    private Advokat advokat;
    private int sertifikatID;
    private int arhivaID;
    private Date datumDobijanjaSertifikata;

    public Arhiva() {
    }

    public Arhiva(Advokat advokat, int sertifikatID, int arhivaID, Date datumDobijanjaSertifikata) {
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

    public int getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(int sertifikatID) {
        this.sertifikatID = sertifikatID;
    }

    public int getArhivaID() {
        return arhivaID;
    }

    public void setArhivaID(int arhivaID) {
        this.arhivaID = arhivaID;
    }
     

}
