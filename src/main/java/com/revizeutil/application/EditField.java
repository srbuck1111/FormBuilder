package com.revizeutil.application;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditField extends JPanel {

    private JTextField fieldInput = new JTextField();
    private JTextField titleInput = new JTextField();
    JComboBox<String> typeInput;
    private JTextField helpInput;

    public EditField() {

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.GRAY));

        JButton delete = new JButton("X");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                killSelf();
            }
        });
        add(delete);

        add(new JLabel("Field: "));
        fieldInput.setPreferredSize(new Dimension(100,20));
        add(fieldInput);

        add(new JLabel("Type: "));
        String[] fieldTypes = {"Text","Long Text","Image","Decimal","Document"};
        typeInput = new JComboBox<String>(fieldTypes);
        typeInput.setPreferredSize(new Dimension(100,20));
        add(typeInput);

        add(new JLabel("Title: "));
        titleInput.setPreferredSize(new Dimension(100,20));
        add(titleInput);

        add(new JLabel("Help Text (optional): "));
        helpInput = new JTextField();
        helpInput.setPreferredSize(new Dimension(500,20));
        add(helpInput);
    }

    public EditField(String fieldName, String title) {
        this();
        setFieldInput(fieldName);
        setTitleInput(title);
    }

    //Me too Man... Me too...
    protected boolean killSelf() {
        try {
            Container parent = getParent();
            parent.remove(this);
            parent.revalidate();
        } catch(Exception e) {
            System.out.println("Error removing field!\n"+e.getMessage());
            return false;
        }
        return true;
    }

    public String getTitle() {
        return titleInput.getText();
    }

    public void setTitleInput(String title) {
        this.titleInput.setText(title);
        revalidate();
    }
    
    public String getField() {
        return fieldInput.getText();
    }

    public void setFieldInput(String fieldInput) {
        this.fieldInput.setText(fieldInput);
        revalidate();
    }
    
    public String getType() {
        return typeInput.getSelectedItem().toString();
    }
    
    public String getHelp() {
        return helpInput.getText();
    }

    @Override
    public String toString() {
        return "["+getField()+","+getType()+"] "+getTitle();
    }

}
