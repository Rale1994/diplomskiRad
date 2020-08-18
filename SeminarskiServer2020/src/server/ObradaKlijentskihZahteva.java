/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readUnshared();
                ServerskiOdgovor so = new ServerskiOdgovor();
                switch (kz.getOperacija()) {

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
