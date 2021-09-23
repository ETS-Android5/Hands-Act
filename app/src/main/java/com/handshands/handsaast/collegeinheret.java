package com.handshands.handsaast;

public class collegeinheret {
    String name,image,background,description;

    public collegeinheret() {
    }

    public collegeinheret(String name, String image,String background,String description) {
        this.name = name;
        this.image = image;
        this.background=background;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
