package com.handshands.handsaast;

public class coachinformation implements Comparable<coachinformation> {
    String name,image,position,wins;

    public coachinformation() {
    }

    public coachinformation(String name, String image, String position, String wins) {
        this.name = name;
        this.image = image;
        this.position = position;
        this.wins = wins;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    @Override
    public int compareTo(coachinformation o) {
        return Integer.parseInt(o.getWins()) - Integer.parseInt(this.wins);
    }
}
