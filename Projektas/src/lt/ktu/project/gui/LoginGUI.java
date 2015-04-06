/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.gui;

import lt.ktu.project.listener.ClickListener;
import lt.ktu.project.listener.ActionType;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Domas
 */
public class LoginGUI  extends JFrame{
    private final JLabel email_title, password_title;
    private final JTextField email;
    private final JPasswordField password;
    private final JButton login, register;
    private final GridBagConstraints gbc = new GridBagConstraints();
    public LoginGUI(){
       super("Login");
       setSize(261, 152);
       setResizable(false);
       setLayout(new GridBagLayout());
        
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension screenSize = tk.getScreenSize();
       setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
        
       Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
       setIconImage(icon);
        
       email_title = new JLabel("E-mail");
       password_title = new JLabel("Password");
       email = new JTextField();
       password = new JPasswordField();
       login = new JButton("Login");
       register = new JButton("Register");
        
       email.setPreferredSize(new Dimension(246, 22));
       password.setPreferredSize(new Dimension(246, 22));
       login.setPreferredSize(new Dimension(120, 30));
       register.setPreferredSize(new Dimension(120, 30));
        
       gbc.insets = new Insets(1, 1, 1, 1);
        
       gbc.gridwidth = 2;
       gbc.gridy = 0;
       add(email_title, gbc);
       gbc.gridy++;
       add(email, gbc);
       gbc.gridy++;        
       add(password_title, gbc);
       gbc.gridy++;
       add(password, gbc);
       gbc.gridy++;
       gbc.gridwidth = 1;
       add(login, gbc);
       gbc.gridx = 1;
       add(register, gbc);
       login.addActionListener(new ClickListener(ActionType.LOGIN));
       register.addActionListener(new ClickListener(ActionType.REGISTER));
       
    }
    public void open(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void dispose(){
        setVisible(false);
        super.dispose();
    }
    public String getEmail(){
        return email.getText();
    }
    public String getPassword(){
        return password.getText();
    }
}