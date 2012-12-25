/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Saddam
 */
public class koneksi {
    static Connection koneksi;
    public static void main(String[]args) throws SQLException{
        getKoneksi();
    }
    public static Connection getKoneksi() throws SQLException {
        if(koneksi == null){
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplikasi_pesantren?zeroDateTimeBehavior=convertToNull", "root", "");
        }
        return koneksi;
    }
    
}
