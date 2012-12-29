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
public class Kitab implements Serializable{
    private int id;
    private String namaKitab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
    }
    
    
}
