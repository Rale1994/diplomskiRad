/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Advokat;

/**
 *
 * @author Rados
 */
public class KontrolerKlijent {

    public static KontrolerKlijent instanca;

    public KontrolerKlijent() {
    }

    public static KontrolerKlijent getInstanca() {
        if (instanca == null) {
            instanca = new KontrolerKlijent();
        }
        return instanca;
    }

    public Advokat ulogujuAdvokata(String korisnickoIme, String lozinka) {
        Advokat advokat = new Advokat(null, null, null, null, null, null, null, korisnickoIme, lozinka, null);
        return advokat;
    }

}
