/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Advokat;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;

/**
 *
 * @author Rados
 */
public class SOUlogujAdvokata extends OpstaSistemskaOperacija {

    private OpstiDomenskiObjkat od;
    private Advokat advokat;
    

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            advokat = getDb().ulogujAdvokata(advokat);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException((ex.getMessage()));
        }
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) {
        return null;
        //TODO validacija
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    

}
