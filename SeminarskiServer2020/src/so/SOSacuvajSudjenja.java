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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOSacuvajSudjenja extends OpstaSistemskaOperacija {

    private Sudjenje sudjenje;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public SOSacuvajSudjenja() {
        this.sudjenje = sudjenje;
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
//        Sudjenje s = null;
//        try {
//            o = getDb().vratiObjekat(sudjenje);
//            s = (Sudjenje) o;
//            if (s == null) {
//                sudjenje.setPoruka("Sudjenja su uspesno sacuvana!");
//                return sudjenje;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SOSacuvajSudjenja.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return sudjenje;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            String datum = sdf.format(sudjenje.getDatum());
            //  sudjenje.setDatum(datum);
            sudjenje = (Sudjenje) getDb().sacuvajObjekat(sudjenje);
        } catch (SQLException ex) {
            Logger.getLogger(SOSacuvajSudjenja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sudjenje getSudjenje() {
        return sudjenje;
    }

    public void setSudjenje(Sudjenje sudjenje) {
        this.sudjenje = sudjenje;
    }

}
