/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjkat;
import domen.Sudjenje;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOObrisiSudjenje extends OpstaSistemskaOperacija {

    private Sudjenje sudjenje;

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
             sudjenje= (Sudjenje) getDb().obrisiObjekat(sudjenje);
        } catch (SQLException ex) {
            Logger.getLogger(SOObrisiSudjenje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sudjenje getSudjenje() {
        return sudjenje;
    }

    public void setSudjenje(Sudjenje sudjenje) {
        this.sudjenje = sudjenje;
    }

}
