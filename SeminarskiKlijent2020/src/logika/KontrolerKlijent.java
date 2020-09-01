/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Advokat;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KomunikacijaSaServerom;
import op.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

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

    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(operacija);
        kz.setParametar(parametar);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getUspesnost() == 1) {
            return so.getOdgovor();
        } else {
            Exception e = so.getException();
            throw e;
        }
    }

    public Advokat ulogujuAdvokata(String korisnickoIme, String lozinka) throws Exception {
        Advokat advokat = new Advokat();
        advokat.setKorisnickoIme(korisnickoIme);
        advokat.setLozinka(lozinka);
        Advokat ulogova = (Advokat) posaljiZahtev(Operacije.ULOGUJ, advokat);
        return ulogova;
    }

}
