/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.SantriException;
import aplikasipesantren.entity.Santri;
import aplikasipesantren.services.SantriDao;
import aplikasipesantrenclient.koneksi.KlienKoneksi;
import aplikasipesantrenclient.model.listener.SantriListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Saddam
 */
public class SantriModel {
    private int id;
    private int idKelas;
    private String namaDepan;
    private String namaBelakang;
    private boolean jenisKelamin;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private int idOrangTua;
    private String noTelp;
    private String noHp;
    private String email;
    private int idKamar;
    private String asalSekolah;
    private String lulusanTerakhir;
    private byte[] foto;
    private SantriDao dao;
    private KlienKoneksi koneksi;
    private SantriListener listener;
    private String host;
    private int port;
    
    public SantriModel() {
        koneksi = new KlienKoneksi();
    }

    public void setListener(SantriListener listener) {
        this.listener = listener;
    }
    
    
    
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

    public boolean isJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
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

    public String getLulusanTerakhir() {
        return lulusanTerakhir;
    }

    public void setLulusanTerakhir(String lulusanTerakhir) {
        this.lulusanTerakhir = lulusanTerakhir;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
    
    protected void fireOnChange(){
        if(listener!=null){
            listener.onChange(this);
        }        
    }
    
    protected void fireOnInsert(Santri santri){
        if(listener != null){
            listener.onInsert(santri);
        }
    }
    
    protected void fireOnUpdate(Santri santri){
        if(listener != null){
            listener.onUpdate(santri);
        }
    }
    
    protected void fireOnDelete(){
        if(listener != null){
            listener.onDelete();
        }
    }
    
    public void insertSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        Santri santri = new Santri();
        santri.setId(id);
        santri.setId_kelas(idKelas);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJeniskelamin(jenisKelamin);
        santri.setTempat_lahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setIdOrangTua(idOrangTua);
        santri.setNoTelp(noTelp);
        santri.setNoHp(noHp);
        santri.setEmail(email);
        santri.setIdKamar(idKamar);
        santri.setAsalSekolah(asalSekolah);
        santri.setLuluasanTerakhir(lulusanTerakhir);
        santri.setFoto(foto);
        dao.insertSantri(santri);
        System.out.println("Santri Berhasil ditambahkan...");
    }
    
    public void updateSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        Santri santri = new Santri();
        santri.setId(id);
        santri.setId_kelas(idKelas);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJeniskelamin(jenisKelamin);
        santri.setTempat_lahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setIdOrangTua(idOrangTua);
        santri.setNoTelp(noTelp);
        santri.setNoHp(noHp);
        santri.setEmail(email);
        santri.setIdKamar(idKamar);
        santri.setAsalSekolah(asalSekolah);
        santri.setLuluasanTerakhir(lulusanTerakhir);
        santri.setFoto(foto);
        dao.updateSantri(id, santri);
        System.out.println("Santri berhasil diupdate..");
    }
    
    public void deleteSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        Santri santri = new Santri();
        santri.setId(id);
        dao.deleteSantri(id);
        System.out.println("Santri berhasil dihapus..");
    }
    
    public List<Santri> getAllSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        List<Santri> listSantri = new ArrayList<Santri>();
        listSantri = dao.getAllSantri();
        
        return listSantri;
    }
    
}
