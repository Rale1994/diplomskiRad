/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public class SOListaSvihKlijenata extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> listaKlijenata;

    public SOListaSvihKlijenata() {
        listaKlijenata = new ArrayList<>();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ArrayList<OpstiDomenskiObjkat> lista = getDb().vratiSveObjekte(new Klijent());
        for (OpstiDomenskiObjkat klijenti : lista) {
            listaKlijenata.add((Klijent) klijenti);
        }

    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

    public void setListaKlijenata(ArrayList<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

}
