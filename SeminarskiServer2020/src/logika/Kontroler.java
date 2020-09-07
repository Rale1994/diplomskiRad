/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Advokat;
import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import exception.ServerskiException;
import java.util.ArrayList;
import so.SOListaSvihKlijenata;
import so.SOPretragaKlijenata;
import so.SOSacuvajKlijenta;
import so.SOUcitajAdvokate;
import so.SOUcitajPrebivalista;
import so.SOUlogujAdvokata;

/**
 *
 * @author Rados
 */
public class Kontroler {

    private static Kontroler instanca;
    DBBroker db;

    public Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Advokat uloguj(Advokat advokat) throws ServerskiException {
        SOUlogujAdvokata so = new SOUlogujAdvokata();
        so.setParametar(advokat);
        so.izvrsiOperaciju();
        return so.getAdvokat();
    }

    public ArrayList<Advokat> sviAdvokati() throws ServerskiException {
        SOUcitajAdvokate soa = new SOUcitajAdvokate();
        soa.izvrsiOperaciju();
        return soa.getAdvokati();
    }

    public ArrayList<Prebivaliste> svaPrebivalista() throws ServerskiException {
        SOUcitajPrebivalista sop = new SOUcitajPrebivalista();
        sop.izvrsiOperaciju();
        return sop.getListaPrebivalista();
    }

    public Klijent sacuvajKlijenta(Klijent klijent) throws ServerskiException {
        SOSacuvajKlijenta sok = new SOSacuvajKlijenta();
        sok.setKlijent(klijent);
        sok.izvrsiOperaciju();
        return sok.getKlijent();
    }

    public ArrayList<Klijent> pretragaKlijenata(String pretraga) throws ServerskiException {
        SOPretragaKlijenata sop = new SOPretragaKlijenata();
        sop.setPretraga(pretraga);
        sop.izvrsiOperaciju();
        return sop.getKlijenti();
    }

    public ArrayList<Klijent> listaSvihKlijenata() throws ServerskiException {
        SOListaSvihKlijenata sol = new SOListaSvihKlijenata();
        sol.izvrsiOperaciju();
        return sol.getListaKlijenata();
    }

}
