/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class Sudjenje extends OpstiDomenskiObjkat implements Serializable {

    private int sudjenjeID;
    private Date datum;
    private int duzinaTrajanja;
    private String napomena;
    private String poruka;
    private PredmetSudjenja predmetSudjenja;
    private Advokat advokat;
    private Klijent klijent;

    public Sudjenje() {
    }

    public Sudjenje(int sudjenjeID, Date datum, int duzinaTrajanja, String napomena, PredmetSudjenja predmetSudjenja, Advokat advokat, Klijent klijent) {
        this.sudjenjeID = sudjenjeID;
        this.datum = datum;
        this.duzinaTrajanja = duzinaTrajanja;
        this.napomena = napomena;
        this.predmetSudjenja = predmetSudjenja;
        this.advokat = advokat;
        this.klijent = klijent;
    }

    public Sudjenje(Date datum, int duzinaTrajanja, String napomena, PredmetSudjenja predmetSudjenja, Advokat advokat, Klijent klijent) {

        this.datum = datum;
        this.duzinaTrajanja = duzinaTrajanja;
        this.napomena = napomena;
        this.predmetSudjenja = predmetSudjenja;
        this.advokat = advokat;
        this.klijent = klijent;
    }

    public PredmetSudjenja getPredmetSudjenja() {
        return predmetSudjenja;
    }

    public void setPredmetSudjenja(PredmetSudjenja predmetSudjenja) {
        this.predmetSudjenja = predmetSudjenja;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public int getSudjenjeID() {
        return sudjenjeID;
    }

    public void setSudjenjeID(int sudjenjeID) {
        this.sudjenjeID = sudjenjeID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(int duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    @Override
    public String vratiImeTabele() {
        return "sudjenje";
    }

    @Override
    public String vratiParametre() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datums = sdf.format(datum);
        return String.format("'%d','%s','%d','%s','%d','%d','%d'", sudjenjeID, datums, duzinaTrajanja, napomena, predmetSudjenja.getPredmetSudjenjaID(), advokat.getAdvokatID(), klijent.getKlijentID());
    }

    @Override
    public int vratiVrednostPK() {
        return sudjenjeID;
    }

    @Override
    public String vratiPk() {
        return "SudjenjeID";
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs) {
        ArrayList<OpstiDomenskiObjkat> listaSudjenja = new ArrayList<>();
        try {

            while (rs.next()) {
                int sudjenjeId = rs.getInt("s.SudjenjeID");
                Date datum = rs.getDate("s.Datum");
                int duzina = rs.getInt("s.DuzinaTrajanja");
                String napomena = rs.getString("s.Napomena");

                PredmetSudjenja ps = new PredmetSudjenja();
                ps.setPredmetSudjenjaID(rs.getInt("ps.PredmetSudjenjaID"));
                ps.setNazivPredmetSudjenja(rs.getString("ps.NazivPredmetaSudjenja"));

                Advokat advokat = new Advokat();
                advokat.setAdvokatID(rs.getInt("a.AdvokatID"));
                advokat.setIme(rs.getString("a.Ime"));
                advokat.setPrezime(rs.getString("a.Prezime"));
                Klijent klijent = new Klijent();
                klijent.setKlijentID(rs.getInt("KlijentID"));

                Sudjenje sudjenje = new Sudjenje(sudjenjeId, datum, duzina, napomena, ps, advokat, klijent);

                listaSudjenja.add(sudjenje);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Sudjenje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSudjenja;
    }

    @Override
    public OpstiDomenskiObjkat vratiObjekat(ResultSet rs) {
        return null;
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String update() {
        return "";
    }

    @Override
    public String vratiKriterijumPretrage() {
        return " k.KlijentID=" + klijent.getKlijentID();
    }

    @Override
    public String vratiJoinUslov() {
        return " JOIN advokat a ON s.AdvokatID=a.AdvokatID JOIN klijent k ON s.KlijentID=k.KlijentID JOIN predmetsudjenja ps ON s.PredmetSudjenjaID=ps.PredmetSudjenjaID";
    }

    @Override
    public String vratiWhereUslov(String pretraga) {
        return "";
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

}
