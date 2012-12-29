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
public class Pelajaran implements Serializable{
    private int id;
    private int idKelas;
    private int idKitab;
    private String namaKelas;
    private String namakitab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamakitab() {
        return namakitab;
    }

    public void setNamakitab(String namakitab) {
        this.namakitab = namakitab;
    }  
    
    
}
