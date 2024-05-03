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
    private Integer width;
    private Integer height;

    public Field() {
        this("Test Name","test_field","text");
    }

    public Field(String fieldName, String fieldTitle, String fieldType) {
        this.fieldTitle = fieldTitle;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public Field(String fieldName, String fieldTitle, String fieldType, String helpText) {
        this(fieldName, fieldTitle, fieldType);
        this.helpText = helpText;
    }

    public Field(String fieldName, String fieldTitle, String fieldType, Integer width, Integer height) {
        this(fieldName, fieldTitle, fieldType);
        this.width = width;
        this.height = height;
    }

    public ArrayList<String> getStrings() {
        ArrayList<String> fieldStrings = new ArrayList<>();
        String line = null;

        File refField = getFileRef();

        try {
            FileReader fr = new FileReader(refField);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (fieldName != null && line.contains("#FIELDNAME#")) line = line.replaceAll("#FIELDNAME#", fieldName);
                if (fieldTitle != null && line.contains("#FIELDTITLE#")) line = line.replaceAll("#FIELDTITLE#", fieldTitle);
                if (line.contains("#WIDTH#")) line = line.replaceAll("#WIDTH#", width == null ? "250" : width.toString());
                if (line.contains("#HEIGHT#")) line = line.replaceAll("#HEIGHT#", height == null ? "250" : height.toString());
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

    // helper method to assign the correct reference file based on the field type
    private File getFileRef() {
        switch(this.fieldType) {
            case "text_area":
                return new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\text-area.jsp");
            case "long_text":
                return new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\long-text.jsp");
            case "image":
                return new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\image.jsp");
            case "document":
                return new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\document.jsp");
            case "text": default:
                return new File("src\\main\\java\\com\\revizeutil\\composer\\templates\\editform\\fields\\text.jsp");
        }

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

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

}
