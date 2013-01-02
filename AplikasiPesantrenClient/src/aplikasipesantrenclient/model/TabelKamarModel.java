/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.entity.Kamar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saddam
 */
public class TabelKamarModel extends AbstractTableModel{
    public List<Kamar> list = new ArrayList<Kamar>();

    public void setList(List<Kamar> list) {
        this.list = list;
    }
    
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNamaGedung();
            case 2 : return list.get(rowIndex).getNama();
            case 3 : return list.get(rowIndex).getJumlah();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID";
            case 1 : return "Gedung";
            case 2 : return "Nama Kamar";
            case 3 : return "Jumlah";
            default : return null;
        }
    }

    public boolean add(Kamar e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Kamar get(int index) {
        return list.get(index);
        
    }

    public Kamar set(int index, Kamar element) {
        try{
            return list.set(index, element);
        }finally{
            fireTableRowsUpdated(index, index);
        }
    }

    public Kamar remove(int index) {
        try{
            return list.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
    
    
}
