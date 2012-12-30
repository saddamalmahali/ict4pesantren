/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.services.GedungDao;
import aplikasipesantrenclient.entitas.Koneksi;
import aplikasipesantrenclient.koneksi.PelajaranKoneksi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saddam
 */
public class GedungModel {
    int id;
    String namaGedung;
    int port = 0;
    String host = "";
    PelajaranKoneksi koneksi;
    GedungDao dao;

    public GedungModel() {
        koneksi = new PelajaranKoneksi();
    }
    
    
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
    
    public void resetGedung(){
        setId(0);
        setNamaGedung("");
    }
    
    public void insertGedung() throws RemoteException, NotBoundException, GedungException{
       dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
       Gedung gedung = new Gedung();
       gedung.setId(id);
       gedung.setNamaGedung(namaGedung);
       dao.insertGedung(gedung);
       System.out.println("Gedung berhasil dimasukan database...");
    }
    
    public void updateGedung()throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        Gedung gedung = new Gedung();
        gedung.setId(id);
        gedung.setNamaGedung(namaGedung);
        dao.updateGedung(id, gedung);
        System.out.println("Gedung berhasil diupdate...");
    }
    
    public void deleteGedung()throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        dao.deleteGedung(id);
        
        System.out.println("Gedung berhasil dihapus...");
    }
    public List<Gedung> getAllGedung()throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        List<Gedung> listGedung = new ArrayList<Gedung>();
        listGedung = dao.getAllGedung();
        return listGedung;
    }
    
    public Gedung getIdGedung(String namaGedung)throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        Gedung gedung = new Gedung();
        
        gedung = dao.getIdGedung(namaGedung);
        
        return gedung;
    }
    
}
