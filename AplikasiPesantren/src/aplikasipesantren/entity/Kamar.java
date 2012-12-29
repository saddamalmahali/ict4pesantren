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
public class Kamar implements Serializable{
    private int id;
    private int idGedung;
    private String nama;
    private String jumlah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGedung() {
        return idGedung;
    }

    public void setIdGedung(int idGedung) {
        this.idGedung = idGedung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
}
