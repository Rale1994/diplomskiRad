/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Advokat;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;

/**
 *
 * @author Rados
 */
public class SOIzmeniAdvokata extends OpstaSistemskaOperacija {

    private Advokat advokat;

    public SOIzmeniAdvokata() {
        this.advokat=advokat;
    }
    

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        advokat=(Advokat) getDb().izmeniPodatke(advokat);
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

}
