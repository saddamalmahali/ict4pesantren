/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.controller;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantrenclient.model.GedungModel;
import aplikasipesantrenclient.view.DialogIsianGedung;
import aplikasipesantrenclient.view.DialogIsianKamar;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saddam
 */
public class GedungController {
    GedungModel model;

    public void setModel(GedungModel model) {
        this.model = model;
    }
    
    public void insertGedung(DialogIsianGedung view){
        int id = Integer.parseInt(view.getTxtIdGedung().getText());
        String namaGedung = view.getTxtNamaGedung().getText();
        
        if(id < 1){
            JOptionPane.showMessageDialog(view, "Id tidak boleh kurang dari 1...");            
        }else if(id>999){
            JOptionPane.showMessageDialog(view, "Id tidak boleh lebih dari 999...");            
        }else if(namaGedung.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama Gedung tidak boleh kosong..");
        }else{
            try {
                model.setId(id);
                model.setNamaGedung(namaGedung);
                model.insertGedung();
                model.getAllNamaGedung();
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambahkan gedung dengan pesan : "+ex.getMessage());
                
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambahkan gedung dengan pesan : "+ex.getMessage());
            } catch (GedungException ex) {
                JOptionPane.showMessageDialog(view, "Gagal menambahkan gedung dengan pesan : "+ex.getMessage());
            }
            JOptionPane.showMessageDialog(view, "Gedung berhasil ditambahkan..");
            
            view.dispose();
        }
        
        
    }
}
