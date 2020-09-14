/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjkat;
import domen.PredmetSudjenja;
import exception.ServerskiException;
import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public class SOUcitajPredmeteSudjenja extends OpstaSistemskaOperacija {

    private ArrayList<PredmetSudjenja> listaPredmetaSudjenja;

    public SOUcitajPredmeteSudjenja() {
        listaPredmetaSudjenja = new ArrayList<>();
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ArrayList<OpstiDomenskiObjkat> lista = getDb().vratiSveObjekte(new PredmetSudjenja());
        for (OpstiDomenskiObjkat opstiDomenskiObjkat : lista) {
            listaPredmetaSudjenja.add((PredmetSudjenja) opstiDomenskiObjkat);
        }

    }

    public ArrayList<PredmetSudjenja> getListaPredmetaSudjenja() {
        return listaPredmetaSudjenja;
    }

    public void setListaPredmetaSudjenja(ArrayList<PredmetSudjenja> listaPredmetaSudjenja) {
        this.listaPredmetaSudjenja = listaPredmetaSudjenja;
    }

}
