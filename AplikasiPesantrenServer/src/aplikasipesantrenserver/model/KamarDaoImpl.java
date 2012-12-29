/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.KamarException;
import aplikasipesantren.entity.Kamar;
import aplikasipesantren.services.KamarDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class KamarDaoImpl extends UnicastRemoteObject implements KamarDao{
    private Connection conn = null;
    private final String qInsert = "INSERT INTO KAMAR(id, id_gedung, blok, jumlah)";
    private final String qUpdate = "UPDATE FROM KAMAR SET id_gedung=?, blok=?, jumlah=? WHERE id=?";
    private final String qDelete = "DELETE FROM KAMAR WHERE id=?";
    private final String qNamaKamar = "SELECT * FROM KAMAR";
    
    public KamarDaoImpl()throws RemoteException, SQLException{
        this.conn = Koneksi.getConn();
    }
    
    @Override
    public void insertKamar(Kamar kamar) throws RemoteException, KamarException {
        
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kamar.getId());
            pstat.setInt(2, kamar.getIdGedung());
            pstat.setString(3, kamar.getNama());
            pstat.setString(4, kamar.getJumlah());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {                
            }
            throw new KamarException("Gagal Menambahkan kamar dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
            
        }
        
        
    }

    @Override
    public void deleteKamar(int id) throws RemoteException, KamarException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KamarException("Gagal Menghapus kamar dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
        
        
    }

    @Override
    public List<Kamar> getAllKamar() throws RemoteException, KamarException {
        
        Statement s = null;
        List<Kamar> listKamar;
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            listKamar = new ArrayList<Kamar>();
            rs = s.executeQuery(qNamaKamar);
            while(rs.next()){
                Kamar kamar = new Kamar();
                kamar.setId(rs.getInt("id"));
                kamar.setIdGedung(rs.getInt("id_gedung"));
                kamar.setNama(rs.getString("nama"));
                kamar.setJumlah(rs.getString("jumlah"));
                listKamar.add(kamar);
            }
        
            conn.commit();
            return listKamar;
        
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KamarException("Tidak dapat mengambil list kamar dengan pesan"+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                rs.close();
                s.close();  
            } catch (SQLException ex) {
                
            }
            
        }  
        
    }
    
}
