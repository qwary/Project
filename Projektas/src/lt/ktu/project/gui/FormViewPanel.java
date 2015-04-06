/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.ktu.project.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lt.ktu.project.listener.ActionType;
import lt.ktu.project.listener.ClickListener;
import lt.ktu.project.utils.Field;
import lt.ktu.project.utils.Form;

/**
 *
 * @author Dominykas
 */
public class FormViewPanel extends JPanel{
    private final GridBagConstraints gbc;
    private HashMap<Field, Component> filledFields;
    public FormViewPanel(){
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridy = 0;
        gbc.gridx = 0;
    }
    public Map<Field, Component> getFilledFields(){
        return (Map<Field, Component>) filledFields.clone();
    }
    public boolean isAllFilled(){
        for(Map.Entry<Field, Component> e:filledFields.entrySet())
            if(!e.getKey().getType().isValid(e.getValue()))
                return false;
        return true;
    }
    public void show(Form form, boolean enabled){
        removeAll();
        filledFields = new HashMap<>();
        Field[] fields = (Field[]) form.getFields();
        for(Field f:fields){
            f.clearComponentValue();
            JLabel title = new JLabel(f.getTitle()+":");
            title.setFont(new Font("Arial", Font.PLAIN, 14));
            title.setForeground(Color.DARK_GRAY);
            title.setPreferredSize(new Dimension(350, 15));
            add(title, gbc);
            gbc.gridy++;
            Component field = f.getComponent();
            filledFields.put(f, field);
            add(field, gbc);
            gbc.gridy++;
        }
        JButton submit = new JButton(">> Submit <<");
        submit.setPreferredSize(new Dimension(120, 30));
        submit.setEnabled(enabled);
        if(enabled)submit.addActionListener(new ClickListener(ActionType.SUBMIT_FORM));
        add(submit, gbc);
        revalidate();
    }
}
