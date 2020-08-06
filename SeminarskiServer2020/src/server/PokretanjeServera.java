/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class PokretanjeServera extends Thread{
    private ServerSocket serverSocket;
    public static int brojPorta=9000;

    public PokretanjeServera() {
        try {
            serverSocket= new ServerSocket(brojPorta);
        } catch (IOException ex) {
            System.out.println("GRESKA! Serverski soket nije kreiran.");
        }
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {                
                Socket s= serverSocket.accept();
            }
        } catch (Exception e) {
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    
}
