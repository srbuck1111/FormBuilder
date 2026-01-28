package com.revizeutil.application;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Header extends JPanel {
    
    private JTextField titleInput;
    private JTextField moduleInput;
    private JCheckBox isListInput;
    JComboBox<String> sortInput;

    public Header() {

        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(new JLabel("Edit Form Title: "));
        titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(100,20));
        add(titleInput);
        
        add(new JLabel("Module Name: "));
        moduleInput = new JTextField();
        moduleInput.setPreferredSize(new Dimension(100,20));
        add(moduleInput);

        add(new JLabel("Has List?: "));
        isListInput = new JCheckBox();
        add(isListInput);

    }

    public String getTitle() {
        return this.titleInput.getText();
    }

    public String getModule() {
        return this.moduleInput.getText();
    }

    public boolean isList() {
        return this.isListInput.isSelected();
    }

}
