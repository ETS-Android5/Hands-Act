package com.handshands.handsaast;

public class engsemesterinheret {
    String name,type,image,background;

    public engsemesterinheret() {
    }

    public engsemesterinheret(String name,  String type,String image,  String background) {
        this.name = name;
        this.type = type;
        this.image=image;
        this.background=background;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
