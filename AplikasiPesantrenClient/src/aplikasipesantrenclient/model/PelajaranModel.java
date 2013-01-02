/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.koneksi.KlienKoneksi;
import aplikasipesantrenclient.model.listener.PelajaranListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class PelajaranModel {
    
    private int id;
    private int idKelas;
    private int idKitab;
    private String namaKelas;
    private String namaKitab;
    private PelajaranListener listener;
    private PelajaranDao dao;
    int port = 0;
    String host = "";
    
    private KlienKoneksi koneksi;
    
    public PelajaranModel() {
         koneksi = new KlienKoneksi();       
    }
    
    
    
    
    public void setListener(PelajaranListener listener) {
        this.listener = listener;
    }   

    public PelajaranListener getListener() {
        return listener;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
        fireOnChange();
    }

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
        fireOnChange();
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
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
    
    
    
    protected void fireOnChange(){
        if(listener!=null){
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pelajaran pelajaran){
        if(listener!=null){
            listener.onInsert(pelajaran);
        }
    }
    
    protected void fireOnUpdate(Pelajaran pelajaran){
        if(listener!=null){
            listener.onUpdate(pelajaran);
        }
    }
    
    protected void fireOnDelete(){
        if(listener!=null){
            listener.onDelete();
        }
    }
    
    public void resetPelajaran(){
        setId(0);
        setIdKelas(0);
        setIdKitab(0);
    }
    
    public void insertPelajaran() throws RemoteException, PelajaranException, AccessException, NotBoundException{
        dao = (PelajaranDao) koneksi.getKoneksi(host, port).lookup("pelajaran");
        Pelajaran pelajaran = new Pelajaran();
        pelajaran.setId(id);
        pelajaran.setIdKelas(idKelas);
        pelajaran.setIdKitab(idKitab);
        dao.insertPelajaran(pelajaran);
        System.out.println("Pelajaran berhasil dimasukan...");
        fireOnInsert(pelajaran);
    }
    
    public void updatePelajaran()throws RemoteException, PelajaranException, AccessException, NotBoundException{
        dao = (PelajaranDao) koneksi.getKoneksi(host, port).lookup("pelajaran");
        Pelajaran p = new Pelajaran();
        p.setId(id);
        p.setIdKelas(idKelas);
        p.setIdKitab(idKitab);
        dao.updatePelajaran(id, p);
        System.out.println("Pelajaran berhasil diupdate...");
        fireOnUpdate(p);
    }
    
    public void deletePelajaran()throws RemoteException, PelajaranException, AccessException, NotBoundException{
        dao = (PelajaranDao) koneksi.getKoneksi(host, port).lookup("pelajaran");
        dao.deletePelajaran(id);
        System.out.println("Pelajaran berhasil dihapus....");
        fireOnDelete();
    }
    
    public void getPelajaran()throws RemoteException, PelajaranException, AccessException, NotBoundException{
        dao = (PelajaranDao) koneksi.getKoneksi(host, port).lookup("pelajaran");
        List<Pelajaran> listPelajaran = new ArrayList<Pelajaran>();
        
        listPelajaran = dao.getPelajaran();
        for(int i=0; i<listPelajaran.size(); i++){
            System.out.println("ID :\t\t"+listPelajaran.get(i).getId()+"");
            System.out.println("id_kelas :\t"+listPelajaran.get(i).getIdKelas()+"");
            System.out.println("id_kitab :\t"+listPelajaran.get(i).getIdKitab()+""); 
            System.out.println("\n\n");
        }
        
    }
            
}
