/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Advokat;
import domen.Arhiva;
import domen.Prebivaliste;
import exception.ServerskiException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class DBBroker {

    private Connection konekcija;

    public DBBroker() {
    }

    public void otvoriKonekciju() throws ServerskiException {
        try {
            Class.forName(Util.getInstance().getDriver());
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);
        } catch (IOException ex) {
            throw new ServerskiException("Greska prilikom ucitavanja propreties fajla!");
        } catch (ClassNotFoundException ex) {
            throw new ServerskiException("Driver nije pronadjen!");
        } catch (SQLException ex) {
            throw new ServerskiException("Konekcija na bazu neuspsna!");
        }

    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Advokat ulogujAdvokata(Advokat advokat) throws SQLException {

        String upit = "SELECT * FROM advokat where KorisnickoIme=? and Lozinka=?";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, advokat.getKorisnickoIme());
        ps.setString(2, advokat.getLozinka());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            advokat.setAdvokatID(rs.getString("AdvokatID"));
            advokat.setJmbg(rs.getInt("JMBG"));
            advokat.setIme(rs.getString("Ime"));
            advokat.setPrezime(rs.getString("Prezime"));
            advokat.setUlica(rs.getString("Ulica"));
            advokat.setBroj(rs.getString("Broj"));
            advokat.setKontaktTelefon(rs.getString("KontaktTelefon"));
            advokat.setKorisnickoIme(rs.getString("KorisnickoIme"));
            advokat.setLozinka(rs.getString("Lozinka"));

            Prebivaliste prebivaliste = new Prebivaliste();
            prebivaliste.setPrebivalisteID(rs.getString("PrebivalisteID"));

            Arhiva arhiva = new Arhiva();
            arhiva.setArhivaID(rs.getString("ArhivaID"));

            advokat.setPrebivaliste(prebivaliste);
            advokat.setArhiva(arhiva);

        }
        return advokat;

    }

}
