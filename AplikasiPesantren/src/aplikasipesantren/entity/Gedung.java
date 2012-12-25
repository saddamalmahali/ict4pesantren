/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.entity;

import java.io.Serializable;

/**
 *
 * @author Saddam
 */
public class Gedung implements Serializable{
    private int id;
    private String namaGedung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaGedung() {
        return namaGedung;
    }

    public void setNamaGedung(String namaGedung) {
        this.namaGedung = namaGedung;
    }
    
    
}
