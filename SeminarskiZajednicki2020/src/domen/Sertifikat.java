/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Rados
 */
public class Sertifikat {
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

}
