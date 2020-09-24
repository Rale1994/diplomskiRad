/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Arhiva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rados
 */
public class ModelTabeleArhiva extends AbstractTableModel {

    ArrayList<Arhiva> lista;
    String[] kolone = {"Naziv sertifikata", "Datum dobijanja"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleArhiva() {
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
        Arhiva arhiva = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return arhiva.getSertifikatID().getNazivSertifikata();
            case 1:
                return sdf.format(arhiva.getDatumDobijanjaSertifikata());
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
