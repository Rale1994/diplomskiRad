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

        String upit = "SELECT * FROM advokat a join prebivaliste p on a.PrebivalisteID= p.PrebivalisteID where KorisnickoIme=? and Lozinka=?";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, advokat.getKorisnickoIme());
        ps.setString(2, advokat.getLozinka());
        ResultSet rs = ps.executeQuery();
        Advokat advokt = null;
        while (rs.next()) {
            advokt = new Advokat();
            advokt.setAdvokatID(rs.getInt("a.AdvokatID"));
            advokt.setJmbg(rs.getString("a.JMBG"));
            advokt.setIme(rs.getString("a.Ime"));
            advokt.setPrezime(rs.getString("a.Prezime"));
            advokt.setUlica(rs.getString("a.Ulica"));
            advokt.setBroj(rs.getString("a.Broj"));
            advokt.setKontaktTelefon(rs.getString("a.KontaktTelefon"));
            advokt.setKorisnickoIme(rs.getString("a.KorisnickoIme"));
            advokt.setLozinka(rs.getString("a.Lozinka"));

            Prebivaliste prebivaliste = new Prebivaliste();
            prebivaliste.setPrebivalisteID(rs.getInt("p.PrebivalisteID"));

        }
        return advokt;

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
//ovde za pretragu unutar tabele

    public ArrayList<OpstiDomenskiObjkat> vratiSveObjektePretrage(OpstiDomenskiObjkat o, String pretraga) throws SQLException {
        String upit = "SELECT * FROM " + o.vratiImeTabele() + " " + o.alijas() + "" + o.vratiJoinUslov() + " " + o.vratiWhereUslov(pretraga.toLowerCase());
        // System.out.println("" + upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        ArrayList<OpstiDomenskiObjkat> listaObjekata = o.RSuTabelu(rs);
        s.close();
        return listaObjekata;
    }

    public ArrayList<OpstiDomenskiObjkat> vratiSveObjekteJoin(OpstiDomenskiObjkat o) throws ServerskiException {
        try {
            String upit = "SELECT * FROM " + o.vratiImeTabele() + " " + o.alijas() + " " + o.vratiJoinUslov();
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

    public ArrayList<OpstiDomenskiObjkat> sacuvajObjekte(ArrayList<OpstiDomenskiObjkat> listaO) throws SQLException {
        for (OpstiDomenskiObjkat o : listaO) {
            try {
                String upit = String.format("INSERT INTO %s VALUES(%s)", o.vratiImeTabele(), o.vratiParametre());
                Statement s = konekcija.createStatement();
                s.execute(upit);
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return listaO;
    }

    public OpstiDomenskiObjkat vratiObjekat(OpstiDomenskiObjkat o) throws SQLException {
        String upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiKriterijumPretrage();
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        o = o.vratiObjekat(rs);
        s.close();
        return o;
    }

    public ArrayList<OpstiDomenskiObjkat> vratiViseObjeakat(OpstiDomenskiObjkat o) throws SQLException {
        String upit = "SELECT * FROM " + o.vratiImeTabele() + " " + o.alijas() + " " + o.vratiJoinUslov() + " WHERE" + o.vratiKriterijumPretrage();
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        ArrayList<OpstiDomenskiObjkat> listaObjekata = o.RSuTabelu(rs);
        s.close();
        return listaObjekata;
    }

    public OpstiDomenskiObjkat izmeniPodatke(OpstiDomenskiObjkat o) {
        String upit = String.format("UPDATE %s SET %s WHERE %s = '%d'", o.vratiImeTabele(), o.update(), o.vratiPk(), o.vratiVrednostPK());
        System.out.println(upit);
        try {
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OpstiDomenskiObjkat obrisiObjekat(OpstiDomenskiObjkat o) throws SQLException {
        String upit = String.format("DELETE FROM %s WHERE %s = %s", o.vratiImeTabele(), o.vratiPk(), o.vratiVrednostPK());
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
        s.close();
        return o;
    }
}
