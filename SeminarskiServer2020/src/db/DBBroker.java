/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Advokat;
import domen.Arhiva;
import domen.Klijent;
import domen.OpstiDomenskiObjkat;
import domen.Prebivaliste;
import exception.ServerskiException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            advokat.setAdvokatID(rs.getInt("AdvokatID"));
            advokat.setJmbg(rs.getString("JMBG"));
            advokat.setIme(rs.getString("Ime"));
            advokat.setPrezime(rs.getString("Prezime"));
            advokat.setUlica(rs.getString("Ulica"));
            advokat.setBroj(rs.getString("Broj"));
            advokat.setKontaktTelefon(rs.getString("KontaktTelefon"));
            advokat.setKorisnickoIme(rs.getString("KorisnickoIme"));
            advokat.setLozinka(rs.getString("Lozinka"));

            Prebivaliste prebivaliste = new Prebivaliste();
            prebivaliste.setPrebivalisteID(rs.getInt("PrebivalisteID"));

            Arhiva arhiva = new Arhiva();
            arhiva.setArhivaID(rs.getInt("ArhivaID"));

            advokat.setPrebivaliste(prebivaliste);
            advokat.setArhiva(arhiva);

        }
        return advokat;

    }

    public ArrayList<OpstiDomenskiObjkat> vratiSveObjekte(OpstiDomenskiObjkat o) throws ServerskiException {
        try {
            String upit = "SELECT * FROM " + o.vratiImeTabele();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            ArrayList<OpstiDomenskiObjkat> listaObjekata = o.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da prikaze podatke o " + o.getClass().getName() + "!");
        }

    }

    public OpstiDomenskiObjkat sacuvajObjekat(OpstiDomenskiObjkat o) throws SQLException {
        String upit = String.format("INSERT INTO %s VALUES(%s)", o.vratiImeTabele(), o.vratiParametre());
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
        s.close();
        return o;
    }

    public ArrayList<Klijent> pretragaKlijenata(String pretraga) throws SQLException {
        ArrayList<Klijent> klijenti = new ArrayList<>();
        String upit = "SELECT * FROM klijent k  join prebivaliste p on k.PrebivalisteID=p.PrebivalisteID join advokat a on k.AdvokatID=a.AdvokatID WHERE k.Ime LIKE '" + pretraga + "' OR k.Prezime LIKE '" + pretraga + "' OR k.JMBG LIKE'" + pretraga + "'";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        /*ArrayList<OpstiDomenskiObjkat> lista = new Klijent().RSuTabelu(rs);
        for (OpstiDomenskiObjkat opstiDomenskiObjkat : lista) {
            Klijent kl = (Klijent) opstiDomenskiObjkat;
            klijenti.add(kl);
        }
        s.close();
        return klijenti;*/
        while (rs.next()) {
            int klijentId = rs.getInt("k.KlijentID");
            String jmbg = rs.getString("k.JMBG");
            String ime = rs.getString("k.Ime");
            String prezime = rs.getString("k.Prezime");
            String ulica = rs.getString("k.Ulica");
            String broj = rs.getString("k.Broj");
            String telefon = rs.getString("k.KontaktTelefon");

            Prebivaliste prebivaliste = new Prebivaliste();
            prebivaliste.setPrebivalisteID(rs.getInt("p.PrebivalisteID"));
            prebivaliste.setNaziv(rs.getString("p.Naziv"));

            Advokat advokat = new Advokat();
            advokat.setAdvokatID(rs.getInt("a.AdvokatID"));
            advokat.setIme(rs.getString("a.Ime"));
            advokat.setPrezime(rs.getString("a.Prezime"));

            Klijent k = new Klijent(klijentId, jmbg, ime, prezime, ulica, broj, telefon, prebivaliste, advokat);
            klijenti.add(k);
        }
         s.close();
        return klijenti;
    }

}
