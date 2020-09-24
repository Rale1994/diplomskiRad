/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjkat;
import domen.Sertifikat;
import exception.ServerskiException;
import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public class SOListaSertifikata extends OpstaSistemskaOperacija {

    private ArrayList<OpstiDomenskiObjkat> listaOD;
    private ArrayList<Sertifikat> listaSertifikata;

    public SOListaSertifikata() {
        listaOD = new ArrayList<>();
        listaSertifikata = new ArrayList<>();
    }

    @Override
    protected OpstiDomenskiObjkat izvrsiValidaciju(OpstiDomenskiObjkat o) throws ServerskiException {
        return null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaOD=getDb().vratiSveObjekte(new Sertifikat());
        for (OpstiDomenskiObjkat opstiDomenskiObjkat : listaOD) {
            listaSertifikata.add((Sertifikat) opstiDomenskiObjkat);
        }
    }

    public ArrayList<OpstiDomenskiObjkat> getListaOD() {
        return listaOD;
    }

    public void setListaOD(ArrayList<OpstiDomenskiObjkat> listaOD) {
        this.listaOD = listaOD;
    }

    public ArrayList<Sertifikat> getListaSertifikata() {
        return listaSertifikata;
    }

    public void setListaSertifikata(ArrayList<Sertifikat> listaSertifikata) {
        this.listaSertifikata = listaSertifikata;
    }

}
