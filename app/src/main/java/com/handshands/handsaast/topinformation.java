package com.handshands.handsaast;

public class topinformation implements Comparable<topinformation>{
    String name,pos,image,points;

    public topinformation() {
    }

    public topinformation(String name, String pos, String image, String points) {
        this.name = name;
        this.pos = pos;
        this.image = image;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public int compareTo(topinformation o) {
        return Integer.parseInt(o.getPoints())-Integer.parseInt(this.points);
    }
}
