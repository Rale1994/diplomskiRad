/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Rados
 */
public class KomunikacijaSaServerom {

    private static KomunikacijaSaServerom instanca;
    private static Socket socket;

    ObjectInputStream in;
    ObjectOutputStream out;

    public KomunikacijaSaServerom() {
    }

    public static KomunikacijaSaServerom getInstanca() {
        if (instanca == null) {
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }

    public  Socket getSocket() {
        return socket;
    }

    public  void setSocket(Socket socket) throws IOException {
        KomunikacijaSaServerom.socket = socket;
        out = new ObjectOutputStream(KomunikacijaSaServerom.socket.getOutputStream());
        in = new ObjectInputStream(KomunikacijaSaServerom.socket.getInputStream());
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        out.writeUnshared(kz);
    }

    public ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        return (ServerskiOdgovor) in.readUnshared();
    }
}
