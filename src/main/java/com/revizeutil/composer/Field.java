package com.revizeutil.composer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Field {
    
    private String fieldTitle;
    private String fieldName;
    private String fieldType;
    private String helpText;

    public Field() {
        new Field("test_title","Test Name","text");
    }

    public Field(String fieldName, String fieldTitle, String fieldType, String helpText) {
        this.fieldTitle = fieldTitle;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        if (helpText != null) this.helpText = helpText;
    }

    public Field(String fieldName, String fieldTitle, String fieldType) {
        this.fieldTitle = fieldTitle;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public ArrayList<String> getStrings() {
        ArrayList<String> fieldStrings = new ArrayList<>();
        String line = null;

        File refField;
        switch(this.fieldType) {
            case "text_area":
                refField = new File("formbuilder\\src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\text-area.jsp");
            break;
            case "long_text":
                refField = new File("formbuilder\\src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\long-text.jsp");
            break;
            case "image":
                refField = new File("formbuilder\\src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\image.jsp");
            break;
            case "document":
                refField = new File("formbuilder\\src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\document.jsp");
            break;
            case "text":
            default:
                refField = new File("formbuilder\\src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\text.jsp");
            break;
        }
        try {
            FileReader fr = new FileReader(refField);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (fieldName != null && line.contains("#FIELDNAME#")) line = line.replaceAll("#FIELDNAME#", fieldName);
                if (fieldTitle != null && line.contains("#FIELDTITLE#")) line = line.replaceAll("#FIELDTITLE#", fieldTitle);
                if (line.contains("#HELPTEXT#")) {
                    if (helpText == null) continue;
                    line = line.replaceAll("#HELPTEXT#", helpText);
                }
                fieldStrings.add(line);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldStrings;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getHelpText() {
        return helpText;
    }

}
