package com.handshands.handsaast;

public class valorantscoremodel {
    String image,name,kda;

    public valorantscoremodel() {
    }

    public valorantscoremodel(String image, String name, String kda) {
        this.image = image;
        this.name = name;
        this.kda = kda;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }
}
