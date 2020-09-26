/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Advokat;
import domen.Arhiva;
import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import domen.PredmetSudjenja;
import domen.Sertifikat;
import domen.Sudjenje;
import java.io.IOException;
import java.util.ArrayList;
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

    public ArrayList<Advokat> sviAdvokati() throws Exception {
        ArrayList<Advokat> listaAdvokata = (ArrayList<Advokat>) posaljiZahtev(Operacije.UCITAJ_ADVOKATE, null);
        return listaAdvokata;
    }

    public ArrayList<Prebivaliste> svaPrebivalista() throws Exception {
        ArrayList<Prebivaliste> listaPrebivalista = (ArrayList<Prebivaliste>) posaljiZahtev(Operacije.UCITAJ_PREBIVALISTA, null);
        return listaPrebivalista;
    }

    public Klijent sacuvajKlijenta(Klijent klijent) throws Exception {
        Klijent poslat = (Klijent) posaljiZahtev(Operacije.UNSEI_NOVOG_KLIJENTA, klijent);
        return poslat;
    }

    public ArrayList<Klijent> listaZaPretragu(String pretraga) throws Exception {
        ArrayList<Klijent> listaZaPretragu = (ArrayList<Klijent>) posaljiZahtev(Operacije.LISTA_ZA_PRETRAGU_KLIJENATA, pretraga);
        return listaZaPretragu;
    }

    public ArrayList<Klijent> sviKlijenti() throws Exception {
        ArrayList<Klijent> listaKlijenata = (ArrayList<Klijent>) posaljiZahtev(Operacije.LISTA_SVIH_KLIJENATA, null);
        return listaKlijenata;
    }

    public Klijent izmeniKlijenta(Klijent klijent) throws Exception {
        Klijent izmenjen = (Klijent) posaljiZahtev(Operacije.IZMENI_KLIJENTA, klijent);
        return izmenjen;
    }

    public ArrayList<PredmetSudjenja> predmetiSudjenja() throws Exception {
        ArrayList<PredmetSudjenja> listaPredmeta = (ArrayList<PredmetSudjenja>) posaljiZahtev(Operacije.LISTA_PREDMETA_SUDJANJA, null);
        return listaPredmeta;
    }

    public ArrayList<OpstiDomenskiObjkat> sacuvajSudjenja(ArrayList<Sudjenje> listaSvihSudjenja) throws Exception {
        ArrayList<OpstiDomenskiObjkat> zaCuvanje = (ArrayList<OpstiDomenskiObjkat>) posaljiZahtev(Operacije.SACUVAJ_SUDJENJA, listaSvihSudjenja);
        return zaCuvanje;
    }

    public ArrayList<Sudjenje> vratiSudnjenja(Klijent k) throws Exception {
        ArrayList<Sudjenje> listaSudjenja = (ArrayList<Sudjenje>) posaljiZahtev(Operacije.VRATI_SUDJENJA_KLIJENTA, k);
        return listaSudjenja;
    }

    public ArrayList<Sertifikat> vratiSertifikate() throws Exception {
        ArrayList<Sertifikat> lista = (ArrayList<Sertifikat>) posaljiZahtev(Operacije.VRATI_SERTIFIKATE, null);
        return lista;
    }

    public Advokat izmeniAdvokata(Advokat izmenjenAdvokat) throws Exception {
        Advokat zaIzmenu = (Advokat) posaljiZahtev(Operacije.IZMENI_ADVOKATA, izmenjenAdvokat);
        return zaIzmenu;
    }

    public Arhiva sacuvajArhivu(Arhiva novaArhiva) throws Exception {
        Arhiva arhiva = (Arhiva) posaljiZahtev(Operacije.SACUVAJ_ARHIVU, novaArhiva);
        return arhiva;
    }

}
