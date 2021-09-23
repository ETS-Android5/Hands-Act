package com.handshands.handsaast;

public class topvalorantmodel implements Comparable<topvalorantmodel>{
    String name,team,image,points;

    public topvalorantmodel() {
    }

    public topvalorantmodel(String name, String team, String image, String points) {
        this.name = name;
        this.team = team;
        this.image = image;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
    public int compareTo(topvalorantmodel o) {
        return Integer.parseInt(o.getPoints())-Integer.parseInt(this.points);

    }
}
