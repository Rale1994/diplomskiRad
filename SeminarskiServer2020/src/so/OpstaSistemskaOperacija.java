/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import exception.ServerskiException;

/**
 *
 * @author Rados
 */
public abstract class OpstaSistemskaOperacija {

    protected DBBroker db;

    public OpstaSistemskaOperacija() {
        this.db = new DBBroker();
    }

        synchronized public void izvrsiOperaciju() throws ServerskiException {
        otvoriKonekciju();
        try {
            izvrsiValidaciju();
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

    protected abstract void izvrsiValidaciju();

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
}
