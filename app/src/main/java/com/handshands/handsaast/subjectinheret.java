package com.handshands.handsaast;

public class subjectinheret
{
    String name,code,type,background;
    public subjectinheret() {
    }

    public subjectinheret(String name, String code, String type,String background) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.background=background;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
