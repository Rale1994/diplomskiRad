/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOPretragaKlijenata extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> klijenti;
    private String pretraga;

    public SOPretragaKlijenata() {
        klijenti = new ArrayList<>();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            klijenti= getDb().pretragaKlijenata(pretraga);
        } catch (SQLException ex) {
            Logger.getLogger(SOPretragaKlijenata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjkat o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(ArrayList<Klijent> klijenti) {
        this.klijenti = klijenti;
    }

    public String getPretraga() {
        return pretraga;
    }

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

}
