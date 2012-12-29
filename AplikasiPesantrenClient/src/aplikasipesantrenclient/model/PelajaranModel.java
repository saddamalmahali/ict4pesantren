/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.koneksi.PelajaranKoneksi;
import aplikasipesantrenclient.model.listener.PelajaranListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
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
    
    private PelajaranKoneksi koneksi;
    
    public PelajaranModel() {
         koneksi = new PelajaranKoneksi();       
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

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
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
    
    public void insertPelajaran(String host,int port) throws RemoteException, PelajaranException, AccessException, NotBoundException{
        dao = (PelajaranDao) koneksi.getKoneksi(host, port).lookup("pelajaran");
        Pelajaran pelajaran = new Pelajaran();
        pelajaran.setId(id);
        pelajaran.setIdKelas(idKelas);
        pelajaran.setIdKitab(idKitab);
        dao.insertPelajaran(pelajaran);
        System.out.println("Pelajaran berhasil dimasukan...");
    }
}
