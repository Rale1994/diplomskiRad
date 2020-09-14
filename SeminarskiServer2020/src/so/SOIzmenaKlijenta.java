/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;

/**
 *
 * @author Rados
 */
public class SOIzmenaKlijenta extends OpstaSistemskaOperacija {

    private Klijent klijent;

    public SOIzmenaKlijenta() {
    }

    public SOIzmenaKlijenta(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        klijent = (Klijent) getDb().izmeniPodatke(klijent);
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

}
