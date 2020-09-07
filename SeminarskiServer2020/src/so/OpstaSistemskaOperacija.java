/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;

/**
 *
 * @author Rados
 */
public abstract class OpstaSistemskaOperacija {

    protected DBBroker db;
    private OpstiDomenskiObjkat o;

    public OpstaSistemskaOperacija() {
        this.db = new DBBroker();
        this.o = o;
    }

    synchronized public void izvrsiOperaciju() throws ServerskiException {
        otvoriKonekciju();
        try {
            izvrsiValidaciju(o);
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (ServerskiException e) {
            ponistiTranskaciju();
            throw e;
        } finally {
            zatvoriKonekciju();
        }

    }

    protected abstract void izvrsiKonkretnuOperaciju() throws ServerskiException;

    protected abstract void izvrsiValidaciju(OpstiDomenskiObjkat o);

    private void potvrdiTransakciju() throws ServerskiException {
        db.commit();
    }

    private void ponistiTranskaciju() throws ServerskiException {
        db.rollback();
    }

    private void otvoriKonekciju() throws ServerskiException {
        db.otvoriKonekciju();
    }

    private void zatvoriKonekciju() throws ServerskiException {
        db.zatvoriKonekciju();
    }

    public DBBroker getDb() {
        return db;
    }

    public void setDb(DBBroker db) {
        this.db = db;
    }

    public OpstiDomenskiObjkat getO() {
        return o;
    }

    public void setO(OpstiDomenskiObjkat o) {
        this.o = o;
    }
}
