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
public class PredmetSudjenja extends OpstiDomenskiObjkat {

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

    @Override
    public String vratiImeTabele() {
        return "predmetsudjenja";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%d', '%s'", predmetSudjenjaID, nazivPredmetSudjenja);
    }

    @Override
    public int vratiVrednostPK() {
        return predmetSudjenjaID;
    }

    @Override
    public String vratiPk() {
        return "predmetSudjenjaID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
