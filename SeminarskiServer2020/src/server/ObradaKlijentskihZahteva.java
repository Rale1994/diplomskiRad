/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Advokat;
import domen.Arhiva;
import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import domen.PredmetSudjenja;
import domen.Sertifikat;
import domen.Sudjenje;
import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import op.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Rados
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket socket;
    private ArrayList<ObradaKlijentskihZahteva> klijenti;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ObradaKlijentskihZahteva(Socket socket, ArrayList<ObradaKlijentskihZahteva> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;

    }

    @Override
    public void run()  {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readUnshared();
                ServerskiOdgovor so = new ServerskiOdgovor();
                ArrayList<Advokat> listaAdvokata = new ArrayList<>();
                ArrayList<Prebivaliste> listaPrebivalista;
                ArrayList<Klijent> listaKlijenata;
                ArrayList<PredmetSudjenja> listaPredmetaSudjenja;
                ArrayList<OpstiDomenskiObjkat> listaSudjenja;
                ArrayList<Sudjenje> sudjenjea;
                ArrayList<Sertifikat> listaSertifikata;
                Klijent klijent;
                Advokat advokat;
                Sudjenje sudjenje;
                Arhiva arhiva;
                switch (kz.getOperacija()) {
                    case Operacije.ULOGUJ:
                        advokat = (Advokat) kz.getParametar();
                        Advokat ulogovaniAdvokat = Kontroler.getInstanca().uloguj(advokat);
                        so.setOdgovor(ulogovaniAdvokat);
                        break;
                    case Operacije.UCITAJ_ADVOKATE:
                        listaAdvokata = Kontroler.getInstanca().sviAdvokati();
                        so.setOdgovor(listaAdvokata);
                        break;
                    case Operacije.UCITAJ_PREBIVALISTA:
                        listaPrebivalista = Kontroler.getInstanca().svaPrebivalista();
                        so.setOdgovor(listaPrebivalista);
                        break;
                    case Operacije.UNSEI_NOVOG_KLIJENTA:
                        klijent = (Klijent) kz.getParametar();
                        Klijent klijentZaCuvanje = null;
                        try {
                            klijentZaCuvanje = Kontroler.getInstanca().sacuvajKlijenta(klijent);
                            so.setOdgovor(klijentZaCuvanje);
                        } catch (ServerskiException ex) {
                            klijentZaCuvanje.setPoruka(ex.getMessage());
                        }
                        break;
                    case Operacije.LISTA_ZA_PRETRAGU_KLIJENATA:
                        String pretraga = (String) kz.getParametar();
                        listaKlijenata = Kontroler.getInstanca().pretragaKlijenata(pretraga);
                        so.setOdgovor(listaKlijenata);
                        break;
                    case Operacije.LISTA_SVIH_KLIJENATA:
                        listaKlijenata = Kontroler.getInstanca().listaSvihKlijenata();
                        so.setOdgovor(listaKlijenata);
                        break;
                    case Operacije.IZMENI_KLIJENTA:
                        klijent = (Klijent) kz.getParametar();
                        Klijent zaIzmenu = Kontroler.getInstanca().izmeniKlijenta(klijent);
                        so.setOdgovor(klijent);
                        break;
                    case Operacije.LISTA_PREDMETA_SUDJANJA:
                        listaPredmetaSudjenja = Kontroler.getInstanca().listaPredmetaSudjenja();
                        so.setOdgovor(listaPredmetaSudjenja);
                        break;
                    case Operacije.SACUVAJ_SUDJENJA:
                        listaSudjenja = (ArrayList<OpstiDomenskiObjkat>) kz.getParametar();
                        ArrayList<OpstiDomenskiObjkat> zaCuvanje = Kontroler.getInstanca().sacuvajSudjenja(listaSudjenja);
                        so.setOdgovor(zaCuvanje);
                        break;
                    case Operacije.VRATI_SUDJENJA_KLIJENTA:
                        klijent = (Klijent) kz.getParametar();
                        sudjenjea = Kontroler.getInstanca().listaSudjnjaKlijenta(klijent);
                        so.setOdgovor(sudjenjea);
                        break;
                    case Operacije.VRATI_SERTIFIKATE:
                        listaSertifikata = Kontroler.getInstanca().vratiSertifikate();
                        so.setOdgovor(listaSertifikata);
                        break;
                    case Operacije.IZMENI_ADVOKATA:
                        advokat = (Advokat) kz.getParametar();
                        Advokat izmenjen = Kontroler.getInstanca().izmeniAdvokata(advokat);
                        so.setOdgovor(izmenjen);
                        break;
                    case Operacije.SACUVAJ_ARHIVU:
                        arhiva = (Arhiva) kz.getParametar();
                        Arhiva zaCuvanjearhiva = Kontroler.getInstanca().sacuvajArhivu(arhiva);
                        so.setOdgovor(zaCuvanjearhiva);
                        break;
                    case Operacije.OBRISI_SUDJENJE:
                        sudjenje = (Sudjenje) kz.getParametar();
                        Sudjenje obrisano= Kontroler.getInstanca().obrisiSudnjenje(sudjenje);
                        so.setOdgovor(obrisano);
                        break;
                }
                so.setUspesnost(1);
                out.writeObject(so);

            }
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServerskiException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ArrayList<ObradaKlijentskihZahteva> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(ArrayList<ObradaKlijentskihZahteva> klijenti) {
        this.klijenti = klijenti;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

}
