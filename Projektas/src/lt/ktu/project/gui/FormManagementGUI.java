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
import static java.awt.Font.PLAIN;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import lt.ktu.project.utils.Field;
import lt.ktu.project.utils.FieldType;
import lt.ktu.project.utils.Form;
import lt.ktu.project.listener.ActionType;
import lt.ktu.project.listener.ClickListener;
import lt.ktu.project.utils.FilledData;
import lt.ktu.project.utils.User;


/**
 *
 * @author Domas
 */
public class FormManagementGUI  extends JFrame{
    private final JLabel privateListTitle, publicListTitle;
    private final JMenuBar jmb;
    private final JMenu user, myForms;
    private final JMenuItem logout, login, register, createForm, deleteForm;
    private final JList publicList, privateList;
    private final JScrollPane sp1, sp2;
    private final DefaultListModel publicListModel, privateListModel;
    private final FormTabbedPane tabbedPane;
    private final GridBagConstraints gbc = new GridBagConstraints();
    public FormManagementGUI(){
        super("Form Management");
        User userr = new User("Vardenis", "Pavardenis", "vardenis.pavardenis@ktu.edu");
        Form temp = new Form("Straipsniai", userr, "2014.03.24");
        temp.setFields(new Field[]{new Field(FieldType.TEXTAREA, "Straipsnis"), new Field(FieldType.TEXTFIELD, "Date")});
        temp.setData(new FilledData[]{
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"}),
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"}),
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"}),
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"}),
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"}),
            new FilledData<>(userr, new Date(), new Object[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas a laoreet lorem, at viverra erat. Aenean venenatis libero at lectus pellentesque bibendum. Duis rhoncus tortor quis elementum fermentum. Phasellus sollicitudin scelerisque luctus. Nullam vestibulum interdum rhoncus.</textarea>", "2015.03.24"})        });
        Form temp2 = new Form("Studentai", new User("Vardenis", "Pavardenis", "vardenis.pavardenis@ktu.edu"), "2014.03.24");
        temp2.setFields(new Field[]{
            new Field(FieldType.TEXTFIELD, "Vardas"), 
            new Field(FieldType.TEXTFIELD, "Pavardė"), 
            new Field(FieldType.TEXTFIELD, "Gimimo metai"), 
            new Field(FieldType.DOUBLE, "Ūgis")});
        temp2.setData(new FilledData[]{
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"}),
            new FilledData<>(userr, new Date(), new Object[]{"Vardenis", "Pavardenis", "1994", "180"})

           
   
        });

        setSize(700, 700);
        setMinimumSize(new Dimension(600, 400));
        setResizable(true);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
        
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon); 
        
        gbc.insets = new Insets(2, 2, 2, 2);
        getContentPane().setLayout(new GridBagLayout());
        
        jmb = new JMenuBar();
        user = new JMenu("User");
        logout = new JMenuItem("Logout");
        login = new JMenuItem("Login");
        register =new JMenuItem("Register");
        myForms = new JMenu("My Forms");
        createForm =new JMenuItem("Create");
        deleteForm = new JMenuItem("Delete");
        publicListTitle = new JLabel("Public forms:");
        publicListTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        privateListTitle = new JLabel("My forms:");
        privateListTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        publicListModel = new DefaultListModel();
        tabbedPane = new FormTabbedPane();
        publicList = new JList(publicListModel);
        sp1 = new JScrollPane(publicList);
        privateListModel = new DefaultListModel();
        privateList = new JList(privateListModel);
        sp2 = new JScrollPane(privateList);
        
        publicList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        publicList.setSelectedIndex(0);
        publicList.setLayoutOrientation(JList.VERTICAL);
        publicList.setFont(new Font("Arial", PLAIN, 12));
        publicList.setBorder(new EmptyBorder(5,5, 5, 5));
        publicListModel.addElement(temp);
        sp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        privateList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        privateList.setSelectedIndex(0);
        privateList.setLayoutOrientation(JList.VERTICAL);
        privateList.setFont(new Font("Arial", PLAIN, 12));
        privateList.setBorder(new EmptyBorder(5,5, 5, 5));
        privateListModel.addElement(temp2);
        privateListModel.addElement(temp);
        publicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        privateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        setJMenuBar(jmb);
        jmb.add(user);
        jmb.add(myForms);
        user.add(logout);
        myForms.add(createForm);
        myForms.add(deleteForm);

        gbc.gridx = 0;
        gbc.gridy = 0;
        getContentPane().add(publicListTitle, gbc);
        gbc.gridy++;
        getContentPane().add(sp1, gbc);
        gbc.gridy++;
        getContentPane().add(privateListTitle, gbc);
        gbc.gridy++;
        getContentPane().add(sp2, gbc);
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.gridx++;
        getContentPane().add(tabbedPane, gbc);
          
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                 fitComponents(); 
            }
        });
        addWindowStateListener((WindowEvent e) -> {
            fitComponents();
        });
        publicList.addListSelectionListener(new ClickListener(ActionType.OPEN_PUBLIC_FORM));
        privateList.addListSelectionListener(new ClickListener(ActionType.OPEN_PRIVATE_FORM));
      
    }
    public FormTabbedPane getTabbedPane(){
        return tabbedPane;
    }
    public Form getPrivateForm(int id){
        return (Form) privateListModel.get(id);
    }
    public Form getPublicForm(int id){
        return (Form) publicListModel.get(id);
    }
    public JList getPrivateList(){
        return privateList;
    }
    public JList getPublicList(){
        return publicList;
    }
    private void fitComponents(){
        int leftSize = (((int)(getWidth()*0.2) < 160)?160:(int)(getWidth()*0.2));
        publicListTitle.setPreferredSize(new Dimension(leftSize-10, 20));
        privateListTitle.setPreferredSize(new Dimension(leftSize-10, 20));
        sp1.setPreferredSize(new Dimension(leftSize, (int) (getHeight()*0.6-65)));
        sp2.setPreferredSize(new Dimension(leftSize, (int) (getHeight()*0.4-65)));
        tabbedPane.setPreferredSize(new Dimension(getWidth()-leftSize-40, getHeight()-80));
    }
    public void addPrivateForm(Form form){
        privateListModel.addElement(form);
    }
    public void addPublicForm(Form form){
        publicListModel.addElement(form);
    }
    public Form[] getPrivateForms(){
        return (Form[]) privateListModel.toArray();
    }
    public Form[] getPublicForms(){
        return (Form[]) publicListModel.toArray();
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
 
}