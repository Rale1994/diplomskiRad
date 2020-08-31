/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author Rados
 */
public abstract class OpstaSistemskaOperacija {

    protected DBBroker db;

    public OpstaSistemskaOperacija() {
        db = new DBBroker();
    }

    synchronized public void izvrsiOperaciju() {
        otvoriKonekciju();
        izvrsiKonkretnuOperaciju();
        potvrdiTransakciju();
        
        
    }
    
    

    private void otvoriKonekciju() {
        db.otvoriKonekciju();
    }

    protected abstract void izvrsiKonkretnuOperaciju();

    private void potvrdiTransakciju() {
        db.commit();
    }

}
