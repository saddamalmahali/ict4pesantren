/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.controller;

import aplikasipesantrenclient.model.LoginModel;
import aplikasipesantrenclient.view.Login;
import java.rmi.RemoteException;

/**
 *
 * @author Saddam
 */
public class LoginController {
    LoginModel model;
    

    public void setModel(LoginModel model) {
        this.model = model;
    }
    
    public void kosongkan(){
        model.reset();
    }
    public void Login()throws RemoteException{
        model.getLogin();
    }
    
    
}
