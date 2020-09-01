/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Advokat;
import exception.ServerskiException;
import java.util.ArrayList;
import so.SOUlogujAdvokata;

/**
 *
 * @author Rados
 */
public class Kontroler {

    private static Kontroler instanca;

    public Kontroler() {
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

}
