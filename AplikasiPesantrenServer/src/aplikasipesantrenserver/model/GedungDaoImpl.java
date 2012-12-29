/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.services.GedungDao;
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
public class GedungDaoImpl extends UnicastRemoteObject implements GedungDao{
    private Connection conn = null;
    private String qInsert = "INSERT INTO GEDUNG (id, nama) values (?,?)";
    private String qUpdate = "UPDATE GEDUNG SET nama=? WHERE id=?";
    private String qDelete = "DELETE FROM GEDUNG id = ?";
    private String qSelectAll = "SELECT * FROM GEDUNG";
    
    
    public GedungDaoImpl()throws SQLException, RemoteException{
        this.conn = Koneksi.getConn();
    }
    @Override
    public void insertGedung(Gedung gedung) throws RemoteException, GedungException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, gedung.getId());
            pstat.setString(2, gedung.getNamaGedung());
            pstat.executeQuery();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
           throw new GedungException("Gagal Menambahkan Gedung dengan pesan"+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            if(pstat!=null){
                try{
                    pstat.close();
                }catch(SQLException ex){
                    
                }
            }
        }
        
        
    }

    @Override
    public void updateGedung(int id, Gedung gedung)throws RemoteException, GedungException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, gedung.getNamaGedung());
            pstat.setInt(2, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new GedungException("Gagal Update Gedung dengan pesan :"+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GedungDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
        
        
    }

    @Override
    public void deleteGedung(int id) throws RemoteException, GedungException {
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
            throw new GedungException("Gagal Menghapus Gedung dengan pesan : "+ex.getMessage());
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
    public List<Gedung> getAllGedung() throws RemoteException, GedungException {
        Statement s=null;
        List<Gedung> listGedung = null;
        ResultSet rs;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            listGedung = new ArrayList<Gedung>();
             rs = s.executeQuery(qSelectAll);
            
            while(rs.next()){
                Gedung gedung = new Gedung();
                gedung.setId(rs.getInt("id"));
                gedung.setNamaGedung(rs.getString("nama"));
             listGedung.add(gedung);
            }
            conn.commit();            
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new GedungException("Gagal Mengambil Gedung dengan Pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }            
            try {
                s.close();
            } catch (SQLException ex) {
                
            }
        }
        return listGedung;        
    }
    
}
