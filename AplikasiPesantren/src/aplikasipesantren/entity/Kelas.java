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
public class Kelas implements Serializable{
    private int id;
    private String namaKelas;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }    
        
}
