/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rados
 */
public class ModelTabeleKlijenti extends AbstractTableModel {

    private ArrayList<Klijent> listaKlijenata;
    private String[] kolone = {"Ime", "Prezime", "JMBG", "Ulica", "Prebivaliste ", "Kontakt telefon", "Advokat"};

    public ModelTabeleKlijenti() {
        listaKlijenata = new ArrayList<>();
    }

    public ModelTabeleKlijenti(ArrayList<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

    @Override
    public int getRowCount() {
        return listaKlijenata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent = listaKlijenata.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return klijent.getIme();
            case 1:
                return klijent.getPrezime();
            case 2:
                return klijent.getJmbg();
            case 3:
                return klijent.getUlica() + " " + klijent.getBroj();
            case 4:
                return klijent.getPrebivaliste().getNaziv();
            case 5:
                return klijent.getKontaktTelefon();
            case 6:
                return klijent.getAdvokat().getIme()+" "+klijent.getAdvokat().getPrezime();

            default:
                return " ";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

    public void setListaKlijenata(ArrayList<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

}
