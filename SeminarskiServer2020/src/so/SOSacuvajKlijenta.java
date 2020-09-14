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
import transfer.ServerskiOdgovor;

/**
 *
 * @author Rados
 */
public class SOSacuvajKlijenta extends OpstaSistemskaOperacija {

    private Klijent klijent;
    private ArrayList<Klijent> klijenti;
    ServerskiOdgovor so = new ServerskiOdgovor();

    public SOSacuvajKlijenta() {
        klijenti = new ArrayList<>();
        this.klijent = klijent;
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        try {
            OpstiDomenskiObjkat opb = getDb().vratiObjekat(klijent);
            
            Klijent k = (Klijent) opb;
            if (k == null) {
                klijent.setPoruka("Klijent je uspesno sacuvan!");
                return klijent;

            }
            if (klijent.getJmbg().equals(k.getJmbg())) {
                klijent.setPoruka("Klijent sa unetim JMBG vec postoji u bazi!");
                return klijent;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOSacuvajKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return klijent;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {

        try {
            if (!(klijent.getPoruka().equals("Vec postoji klijent"))) {
                klijent = (Klijent) getDb().sacuvajObjekat(klijent);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SOSacuvajKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

}
