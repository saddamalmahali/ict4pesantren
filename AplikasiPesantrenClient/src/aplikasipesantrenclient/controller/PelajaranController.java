/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.controller;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantrenclient.model.PelajaranModel;
import aplikasipesantrenclient.view.InternalPelajaran;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saddam
 */
public class PelajaranController {
    PelajaranModel model;

    public void setModel(PelajaranModel model) {
        this.model = model;
    }
    
    public void resetPelajaran(InternalPelajaran vies){
        model.resetPelajaran();
    }
    
    public void insertPelajaran(InternalPelajaran view){
        int id = Integer.parseInt(view.getTxtId().getText());
        int idKelas = Integer.parseInt(view.getTxtIdKelas().getText());
        int idKitab = Integer.parseInt(view.getTxtIdKitab().getText());
        
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Nilai id terlalu Kecil...");            
        }else if(id > 999){
            JOptionPane.showMessageDialog(view, "Nilai id terlalu Besar...");
        }else if(idKelas < 1 ){
            JOptionPane.showMessageDialog(view, "Nilai idKelas terlalu Kecil...");
        }else if(idKelas > 9999){
            JOptionPane.showMessageDialog(view, "Nilai idKelas terlalu Besar...");
        }else if(idKitab <1){
            JOptionPane.showMessageDialog(view, "Nilai idKitab terlalu Kecil...");
        }else if(idKitab > 9999){
            JOptionPane.showMessageDialog(view, "Nilai idKitab terlalu Besar...");
        }else{
            model.setId(id);
            model.setIdKelas(idKelas);
            model.setIdKitab(idKitab);
            try {
                model.insertPelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Remote Server dengan pesan : "+ex.getMessage());
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Sambungan dengan pesan : "+ex.getMessage());
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan dengan pesan : "+ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(view, "Pelajaran Berhasil ditambahkan");
        }        
    }
    
    public void updatePelajaran(InternalPelajaran view){
        int id = Integer.parseInt(view.getTxtId().getText());
        int idKelas = Integer.parseInt(view.getTxtIdKelas().getText());
        int idKitab = Integer.parseInt(view.getTxtIdKitab().getText());
        
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Nilai id terlalu Kecil...");            
        }else if(id > 999){
            JOptionPane.showMessageDialog(view, "Nilai id terlalu Besar...");
        }else if(idKelas < 1 ){
            JOptionPane.showMessageDialog(view, "Nilai idKelas terlalu Kecil...");
        }else if(idKelas > 9999){
            JOptionPane.showMessageDialog(view, "Nilai idKelas terlalu Besar...");
        }else if(idKitab <1){
            JOptionPane.showMessageDialog(view, "Nilai idKitab terlalu Kecil...");
        }else if(idKitab > 9999){
            JOptionPane.showMessageDialog(view, "Nilai idKitab terlalu Besar...");
        }else{
            model.setId(id);
            model.setIdKelas(idKelas);
            model.setIdKitab(idKitab);
            try {
                model.updatePelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Remote Server dengan pesan : "+ex.getMessage());
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Sambungan dengan pesan : "+ex.getMessage());
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan dengan pesan : "+ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(view, "Pelajaran Berhasil diupdate...");
        }
    } 
    
    public void hapusPelajaran(InternalPelajaran view){
        
        
        if(JOptionPane.showConfirmDialog(view, "anda yakin akan menghapus?")==JOptionPane.OK_OPTION){
            int id = Integer.parseInt(view.getTxtId().getText());
            try {
                model.deletePelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Remote Server dengan pesan : "+ex.getMessage());
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan Sambungan dengan pesan : "+ex.getMessage());
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Terjadi Kesalahan dengan pesan : "+ex.getMessage());
            }
        }
        
        
    }
    
    
}
