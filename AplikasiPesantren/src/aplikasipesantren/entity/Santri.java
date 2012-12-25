/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.entity;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Saddam
 */
public class Santri implements Serializable{
    private int id;
    private int id_kelas;
    private String namaDepan;
    private String namaBelakang;
    private boolean jeniskelamin;
    private String tempat_lahir;
    private Date tanggalLahir;
    private String alamat;
    private int idOrangTua;
    private String noTelp;
    private String noHp;
    private String email;
    private int idKamar;
    private String asalSekolah;
    private String luluasanTerakhir;
    private ImageIcon foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public boolean isJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(boolean jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(int idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getLuluasanTerakhir() {
        return luluasanTerakhir;
    }

    public void setLuluasanTerakhir(String luluasanTerakhir) {
        this.luluasanTerakhir = luluasanTerakhir;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
    
    
}
