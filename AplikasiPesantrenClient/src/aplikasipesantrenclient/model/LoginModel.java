/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Saddam
 */
public class LoginModel {
    
    Registry register;
    private int akses;
    private String user;
    private String password;
    
    
    
    public Registry getRegister() {
        return register;
    }

    public void setRegister(Registry register) {
        this.register = register;
    }

    public int getAkses() {
        return akses;
    }

    public void setAkses(int akses) {
        this.akses = akses;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    private int port;

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
    
    
    
    public Registry getLogin() throws RemoteException {
        if(register == null){
            register = LocateRegistry.getRegistry(4444);
        }
        return register;
    }
    
    public void reset(){
        setAkses(1);
        setUser("");
        setPassword("");
    }
    
}
