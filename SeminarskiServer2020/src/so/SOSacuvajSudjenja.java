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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOSacuvajSudjenja extends OpstaSistemskaOperacija {

    private ArrayList<OpstiDomenskiObjkat> listaSudjenja;
   

    public SOSacuvajSudjenja() {
        
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
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {

            listaSudjenja=getDb().sacuvajObjekte(listaSudjenja);
        } catch (SQLException ex) {
            Logger.getLogger(SOSacuvajSudjenja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OpstiDomenskiObjkat> getListaSudjenja() {
        return listaSudjenja;
    }

    public void setListaSudjenja(ArrayList<OpstiDomenskiObjkat> listaSudjenja) {
        this.listaSudjenja = listaSudjenja;
    }

  

   

   

    

   

}
