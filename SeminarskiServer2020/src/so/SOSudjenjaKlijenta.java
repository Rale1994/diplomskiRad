/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Sudjenje;
import exception.ServerskiException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class SOSudjenjaKlijenta extends OpstaSistemskaOperacija {

    private ArrayList<OpstiDomenskiObjkat> listaOd;
    private ArrayList<Sudjenje> listaSudjnjea;
    private OpstiDomenskiObjkat o;

    public SOSudjenjaKlijenta() {
        listaOd = new ArrayList<>();
        listaSudjnjea = new ArrayList<>();
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            Sudjenje s = new Sudjenje();
            s.setKlijent((Klijent) o);
            listaOd = getDb().vratiViseObjeakat(s);
            for (OpstiDomenskiObjkat opstiDomenskiObjkat : listaOd) {
                listaSudjnjea.add((Sudjenje) opstiDomenskiObjkat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SOSudjenjaKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OpstiDomenskiObjkat> getListaOd() {
        return listaOd;
    }

    public void setListaOd(ArrayList<OpstiDomenskiObjkat> listaOd) {
        this.listaOd = listaOd;
    }

    public OpstiDomenskiObjkat getO() {
        return o;
    }

    public void setO(OpstiDomenskiObjkat o) {
        this.o = o;
    }

    public ArrayList<Sudjenje> getListaSudjnjea() {
        return listaSudjnjea;
    }

    public void setListaSudjnjea(ArrayList<Sudjenje> listaSudjnjea) {
        this.listaSudjnjea = listaSudjnjea;
    }

}
