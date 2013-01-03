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
    private PelajaranModel model;
    
    public void setModel(PelajaranModel model) {
        this.model = model;
    }
    
    public void resetPelajaran(InternalPelajaran view){
           model.resetPelajaran();
    }
    
    public void insertPelajaran(InternalPelajaran view){
        int id = Integer.parseInt(view.getTxtId().getText());
        int idKelas = Integer.parseInt(view.getTxtKelasId().getText());
        int idKitab = Integer.parseInt(view.getTxtKitab().getText());
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Id tidak boleh kurang dari 1");
        }else if(id > 999){
            JOptionPane.showMessageDialog(view, "Id tidak boleh lebih dari 999");            
        }else if(idKelas < 1){
            JOptionPane.showMessageDialog(view, "ID Kelas tidak boleh kurang dari 1");
        }else if(idKelas > 9999){
            JOptionPane.showMessageDialog(view, "ID Kelas tidak boleh lebih dari 9999");            
        }else if(idKitab < 1){
            JOptionPane.showMessageDialog(view, "ID kitab tidak boleh kurang dari 1");            
        }else if(idKitab > 9999){
            JOptionPane.showMessageDialog(view, "ID kitab tidak boleh lebih dari 9999");
        }else{
            model.setId(id);
            model.setIdKelas(idKelas);
            model.setIdKitab(idKitab);
            try {
                model.insertPelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Gagal di Remote Server dengan pesan : "+ex.getMessage());
                        
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Gagal dalam Entitas Pelajaran dengan pesan : "+ex);
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambah Pelajaran dengan pesan : "+ex.getMessage());
            }
            JOptionPane.showMessageDialog(view, "Berhasil menambah Pelajaran...!");
            
        }
    }
    
    public void updatePelajaran(InternalPelajaran view){
        int id = Integer.parseInt(view.getTxtId().getText());
        int idKelas = Integer.parseInt(view.getTxtKelasId().getText());
        int idKitab = Integer.parseInt(view.getTxtKitab().getText());
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Id tidak boleh kurang dari 1");
        }else if(id > 999){
            JOptionPane.showMessageDialog(view, "Id tidak boleh lebih dari 999");            
        }else if(idKelas < 1){
            JOptionPane.showMessageDialog(view, "ID Kelas tidak boleh kurang dari 1");
        }else if(idKelas > 9999){
            JOptionPane.showMessageDialog(view, "ID Kelas tidak boleh lebih dari 9999");            
        }else if(idKitab < 1){
            JOptionPane.showMessageDialog(view, "ID kitab tidak boleh kurang dari 1");            
        }else if(idKitab > 9999){
            JOptionPane.showMessageDialog(view, "ID kitab tidak boleh lebih dari 9999");
        }else{
            model.setId(id);
            model.setIdKelas(idKelas);
            model.setIdKitab(idKitab);
            try {
                model.updatePelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Gagal di Remote Server dengan pesan : "+ex.getMessage());
                        
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Gagal dalam Entitas Pelajaran dengan pesan : "+ex);
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambah Pelajaran dengan pesan : "+ex.getMessage());
            }
            JOptionPane.showMessageDialog(view, "Berhasil mengupdate Pelajaran...!");
        }
    }
    
    public void deletePelajaran(InternalPelajaran view){
        if(JOptionPane.showConfirmDialog(view, "Apakah yakin anda akan menghapusnya?")==JOptionPane.OK_OPTION){
            int id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            try {
                model.deletePelajaran();
                model.resetPelajaran();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Gagal di Remote Server dengan pesan : "+ex.getMessage());
                        
            } catch (PelajaranException ex) {
                JOptionPane.showMessageDialog(view, "Gagal dalam Entitas Pelajaran dengan pesan : "+ex);
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambah Pelajaran dengan pesan : "+ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(view, "Berhasil Menghapus Pelajaran...");
        }
    }
    
}
