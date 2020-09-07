/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import exception.ServerskiException;
import java.util.ArrayList;
import logika.Kontroler;

/**
 *
 * @author Rados
 */
public class SOUcitajPrebivalista extends OpstaSistemskaOperacija {

    private ArrayList<Prebivaliste> listaPrebivalista;
    private Prebivaliste parametar;

    public SOUcitajPrebivalista() {
        listaPrebivalista = new ArrayList<>();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ArrayList<OpstiDomenskiObjkat> listaP = getDb().vratiSveObjekte(new Prebivaliste());
        for (OpstiDomenskiObjkat prebivaliste : listaP) {
            listaPrebivalista.add((Prebivaliste) prebivaliste);
        }
    }

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjkat o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Prebivaliste> getListaPrebivalista() {
        return listaPrebivalista;
    }

    public void setListaPrebivalista(ArrayList<Prebivaliste> listaPrebivalista) {
        this.listaPrebivalista = listaPrebivalista;
    }

    public Prebivaliste getParametar() {
        return parametar;
    }

    public void setParametar(Prebivaliste parametar) {
        this.parametar = parametar;
    }

}
