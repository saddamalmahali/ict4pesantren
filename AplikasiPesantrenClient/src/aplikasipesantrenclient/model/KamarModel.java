/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.Exception.KamarException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.entity.Kamar;
import aplikasipesantren.services.GedungDao;
import aplikasipesantren.services.KamarDao;
import aplikasipesantrenclient.koneksi.KlienKoneksi;
import aplikasipesantrenclient.model.listener.KamarListener;
import aplikasipesantrenclient.view.InternalKamar;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class KamarModel {
    private int idKamar;
    private int idGedung;
    private String namaGedung;
    private String namaKamar;
    private String jumlah;
    private int port;
    private String host;
    private KamarDao dao;
    private KamarListener listener;
    private KlienKoneksi koneksi;
   

    public KamarModel() {
        koneksi = new KlienKoneksi();
        
    }
    
    
    
    public void setListener(KamarListener listener) {
        this.listener = listener;
    }    
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }   
    

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
        fireOnChange();
    }

    public int getIdGedung() {
        return idGedung;
    }

    public void setIdGedung(int idGedung) {
        this.idGedung = idGedung;
        fireOnChange();
    }

    public String getNamaGedung() {
        return namaGedung;
    }

    public void setNamaGedung(String namaGedung) {
        this.namaGedung = namaGedung;
        fireOnChange();
    }

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
        fireOnChange();
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if(listener!=null){
            listener.onChange(this);
        }
    }
    
    protected void fireOnDelete(){
        if(listener!=null){
            listener.onDelete();
        }
    }
    protected void fireOnInsert(Kamar kamar){
        if(listener != null){
            listener.onInsert(kamar);
        }
    }
    
    public void resetKamar(){
        setIdKamar(0);
        setIdGedung(0);
        setNamaKamar("");
        setNamaGedung("");
        setJumlah("");
    }
    
    public void insertKamar() throws RemoteException, NotBoundException, KamarException{
        dao = (KamarDao) koneksi.getKoneksi(host, port).lookup("kamar");
        Kamar kamar = new Kamar();
        kamar.setId(idKamar);
        kamar.setIdGedung(idGedung);
        kamar.setNamaGedung(namaGedung);
        kamar.setNama(namaKamar);
        kamar.setJumlah(jumlah);
        dao.insertKamar(kamar);
        fireOnInsert(kamar);
        
        System.out.println("Kamar berhasil ditambahkan...");       
        
    }
    
    public void deleteKamar() throws RemoteException, NotBoundException, KamarException{
        dao = (KamarDao) koneksi.getKoneksi(host, port).lookup("kamar");
        dao.deleteKamar(idKamar);
        System.out.println("Kamar berhasil dihapus..");        
        fireOnDelete();
    }
    
    public List<Kamar> getAllKamar() throws RemoteException, NotBoundException, KamarException{
        dao = (KamarDao) koneksi.getKoneksi(host, port).lookup("kamar");
        List<Kamar> listKamar = new ArrayList<Kamar>();
        listKamar = dao.getKamarKomplit();
        return listKamar;
    }
    
    public Kamar getIdKamar(String namaKamar)throws RemoteException, NotBoundException, KamarException{
        dao = (KamarDao) koneksi.getKoneksi(host, port).lookup("kamar");
        Kamar kamar = new Kamar();
        kamar = dao.getIdKamar(jumlah);
        return kamar;
    }
    
    public Gedung getIdGedung(String namaGedung)throws RemoteException, NotBoundException, GedungException{
        GedungDao daoGedung;
        daoGedung = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        Gedung gedung = new Gedung();
        gedung = daoGedung.getIdGedung(namaGedung);
        return gedung;
    }
    
}
