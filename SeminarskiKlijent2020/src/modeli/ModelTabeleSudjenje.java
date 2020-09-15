/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Sudjenje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rados
 */
public class ModelTabeleSudjenje extends AbstractTableModel {

    private ArrayList<Sudjenje> lista;
    String[] kolone = {"Advokat", "Datum", "Predmet sudjenja", "Duzina trajanja", "Napomena"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private String datum;

    public ModelTabeleSudjenje() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sudjenje sudjenje = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sudjenje.getAdvokat().getIme() + " " + sudjenje.getAdvokat().getPrezime();
            case 1:
                return datum = sdf.format(sudjenje.getDatum());
            case 2:
                return sudjenje.getPredmetSudjenja().getNazivPredmetSudjenja();
            case 3:
                return sudjenje.getDuzinaTrajanja();
            case 4:
                return sudjenje.getNapomena();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajSudjenje(Sudjenje sudjenje) {
        lista.add(sudjenje);
        fireTableDataChanged();
    }

    public ArrayList<Sudjenje> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Sudjenje> lista) {
        this.lista = lista;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void izbrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

}
