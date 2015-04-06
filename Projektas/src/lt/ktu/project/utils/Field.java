/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Domas
 */
public class Field{
    private final FieldType type;
    private final String title;
    private Component component;
    public Field(FieldType type, String title){
        this.type = type;
        this.title = title;
        createComponent();
    }
    public FieldType getType(){
        return type;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return title;
    }
    public void clearComponentValue(){
                switch(type){
            case TEXTAREA:
                ((JTextArea)((JScrollPane)component).getViewport().getComponent(0)).setText("");
                break;
            case INTEGER:
                ((JFormattedTextField)component).setValue((int) 0);
                break;
            case DOUBLE:
                ((JFormattedTextField)component).setValue((double) 0);
                break;
            case BOOLEAN:
                ((JCheckBox)component).setSelected(false);
                break;
            default:
                ((JTextField)component).setText("");
                break;
        }
    }
    public Component getComponent(){
        return component;
    }
    public void createComponent(){
        switch(type){
            case TEXTAREA:
                component = new JTextArea();
                component = new JScrollPane(component);
                component.setFont(new Font("Arial", Font.PLAIN, 14));
                component.setPreferredSize(new Dimension(350, 200));
                break;
            case INTEGER:
                component = new JFormattedTextField(NumberFormat.getIntegerInstance());
                ((JFormattedTextField)component).setValue((int) 0);
                component.setFont(new Font("Arial", Font.PLAIN, 14));
                component.setPreferredSize(new Dimension(350, 25));
                break;
            case DOUBLE:
                component = new JFormattedTextField(NumberFormat.getNumberInstance());
                ((JFormattedTextField)component).setValue((double) 0);
                component.setFont(new Font("Arial", Font.PLAIN, 14));
                component.setPreferredSize(new Dimension(350, 25));
                break;
            case BOOLEAN:
                component = new JCheckBox();
                break;
            default:
                component = new JTextField();
                component.setFont(new Font("Arial", Font.PLAIN, 14));
                component.setPreferredSize(new Dimension(350, 25));
                break;
        }
    }
    
}
