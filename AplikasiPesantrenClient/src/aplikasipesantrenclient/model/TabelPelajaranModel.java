/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;

import aplikasipesantren.entity.Pelajaran;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saddam
 */
public class TabelPelajaranModel extends AbstractTableModel{
    
    private List<Pelajaran> list = new ArrayList<Pelajaran>();

    public List<Pelajaran> getList() {
        return list;
    }
    
    
    
    @Override
    public int getRowCount() {
        
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNamaKelas();
            case 2 : return list.get(rowIndex).getNamaKitab();
            default : return null;
        }
    
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID";
            case 1 : return "Nama Tingkatan";
            case 2 : return "Nama Kitab";
            default : return null;
        }
    }

    public boolean add(Pelajaran e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pelajaran get(int index) {
        return list.get(index);
    }

    public Pelajaran set(int index, Pelajaran element) {
        try{
            return list.set(index, element);
        }finally{
            fireTableRowsUpdated(index, index);
        }
    }

    public Pelajaran remove(int index) {
        try{
            return list.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
}
