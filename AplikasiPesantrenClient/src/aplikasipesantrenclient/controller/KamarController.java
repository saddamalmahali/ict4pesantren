/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.controller;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.Exception.KamarException;
import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Kamar;
import aplikasipesantrenclient.model.KamarModel;
import aplikasipesantrenclient.model.TabelKamarModel;
import aplikasipesantrenclient.model.TabelPelajaranModel;
import aplikasipesantrenclient.view.DialogIsianKamar;
import aplikasipesantrenclient.view.InternalKamar;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saddam
 */
public class KamarController {
    KamarModel model;
    
    public void setModel(KamarModel model) {
        this.model = model;
        
    }
    
    public void resetKamar(DialogIsianKamar view){
        model.resetKamar();
    }
    
    public void insertKamar(DialogIsianKamar view){
        String namaGedung = view.getTxtId().getText();
        int idGedung = 0;
        
        try {
             idGedung = model.getIdGedung(view.getCboGedung().getSelectedItem().toString()).getId();
        } catch (RemoteException ex) {
            Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GedungException ex) {
            Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int id = Integer.parseInt(view.getTxtId().getText());
        String namaKamar = view.getTxtNamaKamar().getText();
        String Jumlah = view.getTxtJumlah().getText();
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Id tidak boleh kurang dari 1");
        }else if(id > 999){
            JOptionPane.showMessageDialog(view, "Id tidak boleh lebih dari 999");            
        }else if(namaKamar.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama Kamar tidak boleh kosong");                    
        }else if(Jumlah.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Kolom Jumlah tidak boleh kosong..");
        }else{
            model.setIdKamar(id);
            model.setIdGedung(idGedung);
            model.setNamaKamar(namaKamar);
            model.setJumlah(Jumlah);
            try {
                
                model.insertKamar();
                model.resetKamar();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Gagal di Remote Server dengan pesan : "+ex.getMessage());
                        
            } catch (KamarException ex) {
                JOptionPane.showMessageDialog(view, "Gagal dalam Entitas Pelajaran dengan pesan : "+ex);
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambah Pelajaran dengan pesan : "+ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(view, "Kamar Berhasil ditambahkan!");
            view.dispose();
        }
    }
    
    public void deleteKamar(InternalKamar view){
        if(JOptionPane.showConfirmDialog(view, "Apakah anda yakin ingin menghapusnya?")==JOptionPane.OK_OPTION){
            int id = Integer.parseInt(view.getTxtIdDataSelection().getText());
            model.setIdKamar(id);
            try {               
                    model.deleteKamar();
                    model.resetKamar();
            } catch (RemoteException ex) {
                Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (KamarException ex) {
                Logger.getLogger(KamarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(view, "Kamar Berhasil dihapus");
        }
    }
    
    
}
