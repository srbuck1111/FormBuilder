package com.revizeutil.composer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileComposer {

    private String formTitle;
    private String formModule;
    private ArrayList<Field> fields = new ArrayList<>();
    private String formType = "form";
    
    public FileComposer() {
        super();
    }

    public FileComposer(String formModule, String formTitle, String formType) {
        this.formModule = formModule;
        this.formTitle = formTitle;
        this.formType = formType;
    }

    public File composeEditForm() {

        File writeFile = new File("output\\"+formModule+"-edit"+formType+".jsp");
        try {
            if (writeFile.createNewFile()) System.out.println("File Created.");
            else System.out.println("File Exists");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ArrayList<String> fileLines = new ArrayList<>();
        String line = null;
        File refFile;
        switch(formType) {
            case "list":
                refFile = new File("templates/editlist/base.jsp");
            break;
            case "form":
            default:
                refFile = new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\base.jsp");
            break;
        }

        try {
            FileReader fr = new FileReader(refFile);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("#HISTORYSTRING#")) line = line.replaceAll("#HISTORYSTRING#", getHistoryString());
                if (line.contains("#MODULENAME#")) line = line.replaceAll("#MODULENAME#", formModule);
                if (line.contains("#FORMTITLE#")) line = line.replaceAll("#FORMTITLE#", formTitle);
                if (line.contains("#EDITFIELDS#")) { 
                    for (Field field : fields) {
                        for (String fieldLine : field.getStrings()) {
                            fileLines.add(fieldLine);
                        }
                    }
                } else {
                    fileLines.add(line);
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(writeFile);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : fileLines)
                 out.write(s+"\n");
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return writeFile;
    }

    protected String getHistoryString() {
        String histString = "";
        for (Field field : fields) {
            histString += field.getFieldName()+"{"+field.getFieldTitle()+"},";
        }
        if (histString.length() > 0) histString = histString.substring(0, histString.length()-1);
        return histString;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public void setFormModule(String formModule) {
        this.formModule = formModule;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

}
