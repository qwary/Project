/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project;

import lt.ktu.project.gui.ConnectingGUI;
import lt.ktu.project.gui.CreateFormGUI;
import lt.ktu.project.gui.FormManagementGUI;
import lt.ktu.project.gui.LoginGUI;
import lt.ktu.project.gui.RegisterGUI;
import lt.ktu.project.utils.Form;

/**
 *
 * @author Domas
 */
public class Main {
    private static LoginGUI loginGUI;
    private static RegisterGUI registerGUI;
    private static FormManagementGUI formManagementGUI;
    private static Thread connection;
    public static LoginGUI getLoginGUI(){
        return loginGUI;
    }
    public static RegisterGUI getRegisterGUI(){
        return registerGUI;
    }
    public static void setRegisterGUI(RegisterGUI registerGUI){
        Main.registerGUI = registerGUI;
    }
    public static FormManagementGUI getFormManagementGUI(){
        return formManagementGUI;
    }
    public static void createForm(Form form){
        //Send data to server
        //IF ALL CORRECT:
        formManagementGUI.addPrivateForm(form);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        formManagementGUI = new FormManagementGUI();
        formManagementGUI.open();
        loginGUI = new LoginGUI();
        loginGUI.open();
        registerGUI = new RegisterGUI();
        registerGUI.open();
        ConnectingGUI conn = new ConnectingGUI();
        conn.open();
        connection = new Thread(new ServerConnection());
        CreateFormGUI gui =new CreateFormGUI();
        gui.open();
    }
    private static class ServerConnection implements Runnable{
        public void check(){
            
            check();
        }
        @Override
        public void run() {
            check();
        }
        
    }
    
}
