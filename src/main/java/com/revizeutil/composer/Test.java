package com.revizeutil.composer;

public class Test {
    
    public static void main(String[] args) {
        FileComposer fc = new FileComposer("module","Edit Form Title","form");
        for (int i = 0; i < 4; i++) {
            Field field = new Field("item"+i,"Test "+i,"long_text");
            fc.addField(field);
        }
        fc.composeEditForm();
    }

}
