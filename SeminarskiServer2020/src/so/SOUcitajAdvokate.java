/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Advokat;
import domen.OpstiDomenskiObjkat;
import exception.ServerskiException;
import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public class SOUcitajAdvokate extends OpstaSistemskaOperacija {

    private ArrayList<Advokat> advokati;

    public SOUcitajAdvokate() {
        advokati= new ArrayList<>();

    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ArrayList<OpstiDomenskiObjkat> lista = db.vratiSveObjekte(new Advokat());
        for (OpstiDomenskiObjkat opstiDomenskiObjkat : lista) {
            advokati.add((Advokat) opstiDomenskiObjkat);
        }
    }

    @Override
    protected void izvrsiValidaciju() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public ArrayList<Advokat> getAdvokati() {
        return advokati;
    }

    public void setAdvokati(ArrayList<Advokat> advokati) {
        this.advokati = advokati;
    }

}
