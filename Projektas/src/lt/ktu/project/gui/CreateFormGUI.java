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
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Dominykas
 */
public class CreateFormGUI extends JFrame{
    private GridBagConstraints gbc;
    private final JMenuBar menuBar;
    private final JMenu add;
    private final JMenuItem add_textbox;
    public CreateFormGUI(){
       super("Create Form");
       setSize(220, 100);
       setResizable(false);
       setLayout(new GridBagLayout());
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension screenSize = tk.getScreenSize();
       setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
        
       Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
       setIconImage(icon);
       menuBar = new JMenuBar();
       add = new JMenu("Add");
       add_textbox = new JMenuItem("TextBox");
       setJMenuBar(menuBar);
       menuBar.add(add);
       add.add(add_textbox);
       gbc = new GridBagConstraints();
       gbc.insets = new Insets(5, 5, 5, 5);

    }
    public void open(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
