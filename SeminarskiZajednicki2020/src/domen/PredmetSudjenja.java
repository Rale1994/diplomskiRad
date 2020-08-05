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
public class PredmetSudjenja {
    
    private int predmetSudjenjaID;
    private String nazivPredmetSudjenja;

    public PredmetSudjenja() {
    }

    public PredmetSudjenja(int predmetSudjenjaID, String nazivPredmetSudjenja) {
        this.predmetSudjenjaID = predmetSudjenjaID;
        this.nazivPredmetSudjenja = nazivPredmetSudjenja;
    }

    public String getNazivPredmetSudjenja() {
        return nazivPredmetSudjenja;
    }

    public void setNazivPredmetSudjenja(String nazivPredmetSudjenja) {
        this.nazivPredmetSudjenja = nazivPredmetSudjenja;
    }

    public int getPredmetSudjenjaID() {
        return predmetSudjenjaID;
    }

    public void setPredmetSudjenjaID(int predmetSudjenjaID) {
        this.predmetSudjenjaID = predmetSudjenjaID;
    }

}
