/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public abstract class OpstiDomenskiObjkat implements Serializable {

    public abstract String vratiImeTabele();

    public abstract String vratiParametre();

    public abstract OpstiDomenskiObjkat vratiObjekte(ResultSet rs);

    public abstract String vratiPk();

    public abstract int vratiVrednostPK();

    public abstract String vratiSlozenPK();

    public abstract ArrayList<OpstiDomenskiObjkat> RSuTabelu(ResultSet rs);
    
    public abstract String alijas();
    
    public abstract String update();

}
