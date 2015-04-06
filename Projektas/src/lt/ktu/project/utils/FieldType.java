/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.utils;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Domas
 */
public enum FieldType {
    TEXTFIELD,
    TEXTAREA,
    INTEGER,
    DOUBLE,
    BOOLEAN,
    COMBOBOX
    ;
    public boolean isValid(Component component){
        if(component instanceof JTextField && ((JTextField)component).getText().isEmpty())
            return false;
        if(component instanceof JTextArea && ((JTextArea)component).getText().isEmpty())
            return false;
        if(component instanceof JFormattedTextField && (int)((JFormattedTextField)component).getValue()<=0)
            return false;
        return true;
    }    
}
