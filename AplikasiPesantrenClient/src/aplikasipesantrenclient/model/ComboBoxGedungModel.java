/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.services.GedungDao;
import aplikasipesantrenclient.view.DialogIsianKamar;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

/**
 *
 * @author Saddam
 */
public class ComboBoxGedungModel extends AbstractListModel implements javax.swing.ComboBoxModel {
    
    private String[] namaGedung = new String[100];
    
    
    private String selection = null;
    public ComboBoxGedungModel() {
        namaGedung = getAllNamaGedung();
    }
    
    
    @Override
    public int getSize() {
       return namaGedung.length;
    }

    @Override
    public Object getElementAt(int index) {
        return namaGedung[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }
    public String[] getAllNamaGedung(){
        String[] namaGedung = new String[20];
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 4444);
            GedungDao dao = (GedungDao) r.lookup("gedung");
            
            List<Gedung> listGedung = new ArrayList<Gedung>();
            listGedung = dao.getGedungName();
            for(int i=0; i<listGedung.size(); i++){
                namaGedung[i]=listGedung.get(i).getNamaGedung();
            }
            
        } catch (GedungException ex) {
            Logger.getLogger(DialogIsianKamar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(DialogIsianKamar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(DialogIsianKamar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(DialogIsianKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return namaGedung;
        
        
        
    }
}
