/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import lt.ktu.project.utils.Field;
import lt.ktu.project.utils.FilledData;
import lt.ktu.project.utils.Form;

/**
 *
 * @author Domas
 */
public class FormTabbedPane extends JTabbedPane{
    private final HTMLEditorKit kit = new HTMLEditorKit();
    private final HTMLDocument doc = new HTMLDocument();
    private final JTextPane results_panel = new JTextPane();
    private final JScrollPane results_scrll, view_scrll;
    private final String htmlStart;
    private final String htmlEnd;
    private FormViewPanel view;
    public FormTabbedPane(){
        super(JTabbedPane.TOP);
        htmlStart = "<html><style type=\"text/css\">table{width:100%}  td{border:1px solid #d1d1d1;}th{font-weight:bold;text-align:center; background-color:#c8ddf2; border:1px solid #98aec4}</style><body><table cellspacing=1 cellpadding=3>";
        htmlEnd = "</table></body></html>";
        results_scrll = new JScrollPane(results_panel);
        view = new FormViewPanel();
        view_scrll = new JScrollPane(view);
        results_panel.setEditorKit(kit);
        results_panel.setDocument(doc);
        results_panel.setEditable(false);
    }
    public void openPublicForm(Form form){
        removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        view.show(form, true);
        addTab(form.getTitle(), view_scrll);
        JPanel details = new JPanel();
        details.setBackground(Color.WHITE);
        details.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        JLabel titles[] = new JLabel[]{
            new JLabel("Form title:", SwingConstants.LEFT),
            new JLabel("Creator:", SwingConstants.LEFT),
            new JLabel("Date created:", SwingConstants.LEFT)
        };
        for(JLabel t:titles){
            t.setFont(new Font("Arial", Font.BOLD, 13));
            t.setPreferredSize(new Dimension(350, 15));
        }
        JLabel values[] = new JLabel[]{
            new JLabel(form.getTitle(), SwingConstants.LEFT),
            new JLabel(form.getUser().getFirstName()+" "+form.getUser().getSecondName(), SwingConstants.LEFT),
            new JLabel(form.getUser().getEmail(), SwingConstants.LEFT),
            new JLabel(form.getDate(), SwingConstants.LEFT)
                
        };
        for(JLabel v:values){
            v.setFont(new Font("Arial", Font.PLAIN, 13));
            v.setPreferredSize(new Dimension(300, 15));
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        details.add(titles[0], gbc);
        gbc.gridy++;
        details.add(values[0], gbc);
        gbc.gridy++;
        details.add(titles[1], gbc);
        gbc.gridy++;
        details.add(values[1], gbc);
        gbc.gridy++;
        details.add(values[2], gbc);
        gbc.gridy++;
        details.add(titles[2], gbc);
        gbc.gridy++;
        details.add(values[3], gbc);
        gbc.gridy++;
        details.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        addTab("Details", details); 
    }
    public void openPrivateForm(Form form){
            
        removeAll();
        String htmlContent = "<tr>";
        for(Field t: form.getFields()) htmlContent += "<th>"+t.getTitle()+"</th>"; 
        htmlContent += "<th>Submited By</th>"; 
        htmlContent += "</tr>";
        for(FilledData e:form.getData()){
            htmlContent += "<tr>";
            for(Object i:e) htmlContent += "<td>"+(String)i+"</td>";
            htmlContent += "<td>"+e.getUser().getFirstName()+" "+e.getUser().getSecondName()+"<br/>"+e.getUser().getEmail()+"</td>";
            htmlContent += "</tr>";
        }
        try {
            results_panel.setText("");
            kit.insertHTML(doc, doc.getLength(), htmlStart+htmlContent+htmlEnd, 0, 0, null);    
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
        results_panel.setCaretPosition(0);
        addTab("Results ("+form.getData().length+")", results_scrll);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        view.show(form, false);
        addTab("View", view_scrll);
        JPanel details = new JPanel();
        details.setBackground(Color.WHITE);
        details.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        JLabel titles[] = new JLabel[]{
            new JLabel("Form title:", SwingConstants.LEFT),
            new JLabel("Creator:", SwingConstants.LEFT),
            new JLabel("Date created:", SwingConstants.LEFT)
        };
        for(JLabel t:titles){
            t.setFont(new Font("Arial", Font.BOLD, 13));
            t.setPreferredSize(new Dimension(350, 15));
        }
        JLabel values[] = new JLabel[]{
            new JLabel(form.getTitle(), SwingConstants.LEFT),
            new JLabel(form.getUser().getFirstName()+" "+form.getUser().getSecondName(), SwingConstants.LEFT),
            new JLabel(form.getUser().getEmail(), SwingConstants.LEFT),
            new JLabel(form.getDate(), SwingConstants.LEFT)
                
        };
        for(JLabel v:values){
            v.setFont(new Font("Arial", Font.PLAIN, 13));
            v.setPreferredSize(new Dimension(300, 15));
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        details.add(titles[0], gbc);
        gbc.gridy++;
        details.add(values[0], gbc);
        gbc.gridy++;
        details.add(titles[1], gbc);
        gbc.gridy++;
        details.add(values[1], gbc);
        gbc.gridy++;
        details.add(values[2], gbc);
        gbc.gridy++;
        details.add(titles[2], gbc);
        gbc.gridy++;
        details.add(values[3], gbc);
        gbc.gridy++;
        details.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        addTab("Details", details);  
    }
    public FormViewPanel getFormView(){
        return view;
    }
}
