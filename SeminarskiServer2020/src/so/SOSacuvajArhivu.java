/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Arhiva;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOSacuvajArhivu extends OpstaSistemskaOperacija {

    private Arhiva arhiva;

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            arhiva= (Arhiva) getDb().sacuvajObjekat(arhiva);
        } catch (SQLException ex) {
            Logger.getLogger(SOSacuvajArhivu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Arhiva getArhiva() {
        return arhiva;
    }

    public void setArhiva(Arhiva arhiva) {
        this.arhiva = arhiva;
    }

}
