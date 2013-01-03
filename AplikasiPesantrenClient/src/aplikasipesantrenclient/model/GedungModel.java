/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.services.GedungDao;
import aplikasipesantrenclient.entitas.Koneksi;
import aplikasipesantrenclient.koneksi.KlienKoneksi;
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
    KlienKoneksi koneksi;
    GedungDao dao;

    public GedungModel() {
        koneksi = new KlienKoneksi();
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
    
    public int getId(String namaGedung)throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        int id = dao.getIdGedung(namaGedung).getId();
        return id;
    }
    
    public String[] getAllNamaGedung()throws RemoteException, NotBoundException, GedungException{
        dao = (GedungDao) koneksi.getKoneksi(host, port).lookup("gedung");
        String[] namaGedung = new String[100];
        List<Gedung> listGedung = new ArrayList<Gedung>();
        listGedung = dao.getAllGedung();
        for(int i=0; id<listGedung.size(); i++){
            namaGedung[i]=listGedung.get(i).getNamaGedung();
        }
        
        return namaGedung;
    }
    
    
}
