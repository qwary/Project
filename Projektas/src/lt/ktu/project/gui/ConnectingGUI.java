/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.ktu.project.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Dominykas
 */
public class ConnectingGUI extends JFrame{
    private JLabel title, info;
    private Thread animation;
    private GridBagConstraints gbc;
    public ConnectingGUI(){
       super("Server");
       setSize(220, 100);
       setResizable(false);
       setLayout(new GridBagLayout());
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension screenSize = tk.getScreenSize();
       setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
        
       Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
       setIconImage(icon);
       title = new JLabel("Please wait!");
       title.setFont(new Font("Arial", Font.BOLD, 16));
       info = new JLabel();
       info.setFont(new Font("Arial", Font.PLAIN, 12));
       gbc = new GridBagConstraints();
       gbc.insets = new Insets(5, 5, 5, 5);
        
       gbc.gridwidth = 2;
       gbc.gridy = 0;
       add(title, gbc);
       gbc.gridy++;
    
       add(info, gbc);
       animation = new Thread(new LoadingAnimation());
       animation.start();
    }
    public void open(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private class LoadingAnimation implements Runnable{
        public void animate(int i){
            String temp = "Connecting";
            for(int ii = 0; ii < i; ii++)
                temp += '.';
            ConnectingGUI.this.info.setText(temp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConnectingGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            animate((i>=3)?0:i+1);
        }
        @Override
        public void run() {
            animate(0);
        }
        
    }
}
