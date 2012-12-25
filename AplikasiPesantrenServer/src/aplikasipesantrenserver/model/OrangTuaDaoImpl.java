/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.OrangTuaException;
import aplikasipesantren.entity.OrangTua;
import aplikasipesantren.services.OrangTuaDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
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
public class OrangTuaDaoImpl implements OrangTuaDao{
    
   private Connection conn = null;
   private String qInsert = "INSERT INTO ORANG_TUA (ID, NAMA_DEPAN, NAMA_BELAKANG,"
           + "ALMARHUM, TEMPAT_LAHIR, TANGGAL_LAHIR, ALAMAT, NO_TELP) VALUES (?,?,?,?,?,?,?,?)";
   private String qUpdate = "UPDATE FROM ORANG_TUA SET NAMA_DEPAN=?, NAMA_BELAKANG=?, ALMARHUM=?, "
           + "TEMPAT_LAHIR=?, TANGGAL_LAHIR=?, ALAMAT=?, NO_TELP=? WHERE ID=?";
   private String qDelete = "DELETE FROM ORANG_TUA WHERE ID=?";
   private String qSelectAll = "SELECT * FROM ORANG_TUA";

    public OrangTuaDaoImpl() throws RemoteException, OrangTuaException{
        
        if(conn==null){
            try {
                conn = Koneksi.getConn();
            } catch (SQLException ex) {
                throw new OrangTuaException("Gagal Menyambung ke database dengan pesan : "+ex.getMessage());
            }
            return ;
        }
    
    }
   
   
   
    
    
    @Override
    public void insertOrangTua(OrangTua ortu) throws RemoteException, OrangTuaException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, ortu.getId());
            pstat.setString(2, ortu.getNama_depan());
            pstat.setString(3, ortu.getNama_belakang());
            pstat.setBoolean(4, ortu.isAlm());
            pstat.setString(5, ortu.getTempatLahir());
            pstat.setDate(6, new Date(ortu.getTanggalLahir().getDate()));
            pstat.setString(7, ortu.getAlamat());
            pstat.setString(8, ortu.getNo_telp());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal menambahkan orang tua dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updateOrangTua(int id, OrangTua ortu) throws RemoteException, OrangTuaException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            
            pstat.setString(1, ortu.getNama_depan());
            pstat.setString(2, ortu.getNama_belakang());
            pstat.setBoolean(3, ortu.isAlm());
            pstat.setString(4, ortu.getTempatLahir());
            pstat.setDate(5, new Date(ortu.getTanggalLahir().getDate()));
            pstat.setString(6, ortu.getAlamat());
            pstat.setString(7, ortu.getNo_telp());
            pstat.setInt(8, ortu.getId());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal mengupdate orang tua dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteOrangTua(int id) throws RemoteException, OrangTuaException {
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
            throw new OrangTuaException("Gagal menghapus orang tua dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public List<OrangTua> getAllOrangTua() throws RemoteException, OrangTuaException {
        Statement s = null;
        List<OrangTua> listOrangtua = null;
        ResultSet rs = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            listOrangtua = new ArrayList<OrangTua>();
            rs = s.executeQuery(qSelectAll);
            
            while(rs.next()){
                OrangTua ortu = new OrangTua();
                ortu.setId(rs.getInt("id"));
                ortu.setNama_depan(rs.getString("nama_depan"));
                ortu.setNama_belakang(rs.getString("nama_belakang"));
                ortu.setAlm(rs.getBoolean("almarhum"));
                ortu.setTempatLahir(rs.getString("tempat_lahir"));
                ortu.setTanggalLahir(rs.getDate("tanggal_lahir"));
                ortu.setAlamat(rs.getString("alamat"));
                ortu.setNo_telp(rs.getString("no_telp"));
                listOrangtua.add(ortu);
            }
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal mengambil list orang tua dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
            } catch (SQLException ex) {
                
            }
        }
        return listOrangtua;
    }
    
}
