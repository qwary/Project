/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lt.ktu.project.Main;
import lt.ktu.project.gui.FormManagementGUI;
import lt.ktu.project.gui.RegisterGUI;
import lt.ktu.project.utils.Field;

/**
 *
 * @author Domas
 */
public class ClickListener implements ActionListener, ListSelectionListener{
    ActionType type;
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(type){
            case LOGIN:
                break;
            case REGISTER:
                Main.getLoginGUI().dispose();
                RegisterGUI registerGUI = new RegisterGUI();
                registerGUI.open();
                Main.setRegisterGUI(registerGUI);
                break;
            case REGISTER_SUBMIT:
                break;
            case SUBMIT_FORM:
                if(!Main.getFormManagementGUI().getTabbedPane().getFormView().isAllFilled())
                {
                    JOptionPane.showMessageDialog(null, "Fill all fields and then submit!");
                    return;
                }
                Map<Field, Component> fields = Main.getFormManagementGUI().getTabbedPane().getFormView().getFilledFields();
                
                break;
        }
    }
    public ClickListener(ActionType type){
        this.type = type;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        FormManagementGUI gui = Main.getFormManagementGUI();
        if(gui == null)return;
        switch(type){
            case OPEN_PRIVATE_FORM:
                if(gui.getPrivateList().getSelectedIndex() < 0)return;
                gui.getPublicList().clearSelection();
                gui.getTabbedPane().openPrivateForm(gui.getPrivateForm(gui.getPrivateList().getSelectedIndex()));
              
                break;
            case OPEN_PUBLIC_FORM:
                if(gui.getPublicList().getSelectedIndex() < 0)return;
                gui.getPrivateList().clearSelection();
                gui.getTabbedPane().openPublicForm(gui.getPublicForm(gui.getPublicList().getSelectedIndex()));
                break;
        }
    }
    
}
