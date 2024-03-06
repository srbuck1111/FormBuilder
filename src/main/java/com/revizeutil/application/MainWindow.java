package com.revizeutil.application;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.revizeutil.composer.Field;
import com.revizeutil.composer.FileComposer;

public class MainWindow extends JFrame {

    Header header;
    JPanel editFields;
    JPanel footer;

    FileComposer fc;

    public MainWindow() {
        setTitle("Form Builder");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200,500);
        setLocationRelativeTo(null);

        header = new Header();
        add(header, BorderLayout.NORTH);
        
        JPanel editContainer = new JPanel();
        editContainer.setLayout(new BorderLayout());
            editFields = new JPanel();
            editFields.setLayout(new BoxLayout(editFields, BoxLayout.Y_AXIS));
        editContainer.add(editFields,BorderLayout.PAGE_START);
        add(new JScrollPane(editContainer));

        JPanel flyoutLeft = new JPanel();
        add(flyoutLeft, BorderLayout.WEST);
        
        JPanel flyoutRight = new JPanel();
        add(flyoutRight, BorderLayout.EAST);

        footer = new JPanel();
            JButton addFieldButton = new JButton("Add Field");
            addFieldButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditField editField = new EditField();
                    editFields.add(editField);
                    revalidate();
                }
            });
            footer.add(addFieldButton);
            
            JButton createFormButton = new JButton("Create Edit Form");
            createFormButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createEditForm();
                    revalidate();
                }
            });
            footer.add(createFormButton);
        add(footer, BorderLayout.SOUTH);

    }

    private void createEditForm() {
        fc = new FileComposer(header.getModule(),header.getTitle(),"form");
        Component[] components = editFields.getComponents();
        for (Component component : components) {
            if (component instanceof EditField) {
                EditField editField = ((EditField)component);
                String fieldName = editField.getField();
                String title = editField.getTitle();
                String type = editField.getType();
                String help = editField.getHelp();
                
                Field newField = new Field(fieldName,title,type,help);
                fc.addField(newField);
            }
        }
        fc.composeEditForm();
    }

}