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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
/**
 *
 * @author Domas
 */
public class RegisterGUI  extends JFrame{
    private final JLabel firstname_title, secondname_title, email_title, password_title, repeat_password_title;
    private final JTextField firstname, secondname, email;
    private final JPasswordField password, repeat_password;
    private final JButton register;
    private final GridBagConstraints gbc = new GridBagConstraints();
    public RegisterGUI(){
       super("Register");
       setSize(261, 285);
       setResizable(false);
       setLayout(new GridBagLayout());
        
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension screenSize = tk.getScreenSize();
       setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
        
       Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
       setIconImage(icon);
        firstname_title = new JLabel("First name");
        secondname_title = new JLabel("Second name");
        email_title = new JLabel("E-mail");
        password_title = new JLabel("Password");
        repeat_password_title = new JLabel("Repeat password");
        firstname = new JTextField();
        secondname = new JTextField();
        email = new JTextField();
        password = new JPasswordField();
        repeat_password = new JPasswordField();
        register = new JButton("Register");
        
        
        firstname_title.setPreferredSize(new Dimension(246, 18));
        secondname_title.setPreferredSize(new Dimension(246, 18));
        email_title.setPreferredSize(new Dimension(246, 18));
        password_title.setPreferredSize(new Dimension(246, 18));
        repeat_password_title.setPreferredSize(new Dimension(246, 18));
        firstname.setPreferredSize(new Dimension(246, 22));
        secondname.setPreferredSize(new Dimension(246, 22));
        email.setPreferredSize(new Dimension(246, 22));
        password.setPreferredSize(new Dimension(246, 22));
        repeat_password.setPreferredSize(new Dimension(246, 22));
        register.setPreferredSize(new Dimension(246, 30));
        
        gbc.insets = new Insets(1, 1, 1, 1);
        
        gbc.gridy = 0;
        add(firstname_title, gbc);
        gbc.gridy++;
        add(firstname, gbc);
        gbc.gridy++;           
        add(secondname_title, gbc);
        gbc.gridy++;
        add(secondname, gbc);
        gbc.gridy++;   
        add(email_title, gbc);
        gbc.gridy++;
        add(email, gbc);
        gbc.gridy++;        
        add(password_title, gbc);
        gbc.gridy++;
        add(password, gbc);
        gbc.gridy++;
        add(repeat_password_title, gbc);
        gbc.gridy++;
        add(repeat_password, gbc);
        gbc.gridy++;
        add(register, gbc);
        register.addActionListener(new ClickListener(ActionType.REGISTER_SUBMIT));
        
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
    public String getRepeatedPassword(){
        return repeat_password.getText();
    }

}