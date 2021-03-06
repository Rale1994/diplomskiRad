/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Advokat;
import domen.Arhiva;
import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import domen.PredmetSudjenja;
import domen.Sertifikat;
import domen.Sudjenje;
import exception.ServerskiException;
import java.util.ArrayList;
import so.SOIzmenaKlijenta;
import so.SOIzmeniAdvokata;
import so.SOListaSertifikata;
import so.SOListaSvihKlijenata;
import so.SOObrisiSudjenje;
import so.SOPretragaKlijenata;
import so.SOSacuvajArhivu;
import so.SOSacuvajKlijenta;
import so.SOSacuvajSudjenja;
import so.SOSudjenjaKlijenta;
import so.SOUcitajAdvokate;
import so.SOUcitajPrebivalista;
import so.SOUcitajPredmeteSudjenja;
import so.SOUlogujAdvokata;
import transfer.ServerskiOdgovor;

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
        so.setAdvokat(advokat);
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

    public Klijent izmeniKlijenta(Klijent klijent) throws ServerskiException {
        SOIzmenaKlijenta soi = new SOIzmenaKlijenta();
        soi.setKlijent(klijent);
        soi.izvrsiOperaciju();
        return soi.getKlijent();
    }

    public ArrayList<PredmetSudjenja> listaPredmetaSudjenja() throws ServerskiException {
        SOUcitajPredmeteSudjenja sop = new SOUcitajPredmeteSudjenja();
        sop.izvrsiOperaciju();
        return sop.getListaPredmetaSudjenja();
    }

    public ArrayList<OpstiDomenskiObjkat> sacuvajSudjenja(ArrayList<OpstiDomenskiObjkat> lista) throws ServerskiException {
        SOSacuvajSudjenja sos = new SOSacuvajSudjenja();
        sos.setListaSudjenja(lista);
        sos.izvrsiOperaciju();
        return sos.getListaSudjenja();
    }

    public ArrayList<Sudjenje> listaSudjnjaKlijenta(Klijent klijent) throws ServerskiException {
        SOSudjenjaKlijenta sk = new SOSudjenjaKlijenta();
        sk.setO(klijent);
        sk.izvrsiOperaciju();
        return sk.getListaSudjnjea();
    }

    public ArrayList<Sertifikat> vratiSertifikate() throws ServerskiException {
        SOListaSertifikata sos = new SOListaSertifikata();
        sos.izvrsiOperaciju();
        return sos.getListaSertifikata();
    }

    public Advokat izmeniAdvokata(Advokat advokat) throws ServerskiException {
        SOIzmeniAdvokata soia = new SOIzmeniAdvokata();
        soia.setAdvokat(advokat);
        soia.izvrsiOperaciju();
        return soia.getAdvokat();
    }

    public Arhiva sacuvajArhivu(Arhiva arhiva) throws ServerskiException {
        SOSacuvajArhivu soa = new SOSacuvajArhivu();
        soa.setArhiva(arhiva);
        soa.izvrsiOperaciju();
        return soa.getArhiva();
    }

    public Sudjenje obrisiSudnjenje(Sudjenje sudjenje) throws ServerskiException {
        SOObrisiSudjenje sob = new SOObrisiSudjenje();
        sob.setSudjenje(sudjenje);
        sob.izvrsiOperaciju();
        return sob.getSudjenje();
    }

}
