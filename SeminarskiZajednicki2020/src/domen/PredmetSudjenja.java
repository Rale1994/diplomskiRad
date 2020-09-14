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
public class PredmetSudjenja extends OpstiDomenskiObjkat implements Serializable {

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
    public String toString() {
        return "" + nazivPredmetSudjenja;
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

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> lista = new ArrayList<>();
        try {

            while (rs.next()) {

                int predmetetSudjenjaID = rs.getInt("PredmetSudjenjaID");
                String naziv = rs.getString("NazivPredmetaSudjenja");
                PredmetSudjenja predemt = new PredmetSudjenja(predmetetSudjenjaID, naziv);
                lista.add(predemt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PredmetSudjenja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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
