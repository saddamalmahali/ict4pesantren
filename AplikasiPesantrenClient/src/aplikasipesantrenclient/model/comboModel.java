/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.entitas.Koneksi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Saddam
 */
public class comboModel extends AbstractListModel implements ComboBoxModel {
    Koneksi k = new Koneksi();
    PelajaranDao dao;
    PelajaranModel modelPelajaran = new PelajaranModel("127.0.0.1", 4444);
    int index;
    
    
    @Override
    public int getSize() {
        return 102;
    }

    @Override
    public Object getElementAt(int index) {
        
        String [] nama = new String[10];
        List<Pelajaran> list= null;
        try {
            list = modelPelajaran.getAllPelajaran();
        } catch (RemoteException ex) {
            Logger.getLogger(comboModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(comboModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PelajaranException ex) {
            Logger.getLogger(comboModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0; i<=list.size(); i++){
            nama[i] = list.get(i).getNamaKelas();            
        }
        
        return nama[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
