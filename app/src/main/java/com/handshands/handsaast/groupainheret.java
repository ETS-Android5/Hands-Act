package com.handshands.handsaast;

public class groupainheret implements Comparable<groupainheret> {
    String Calculation,image,played,points,team,winlose;
    public groupainheret() {
    }
    public groupainheret(String calculation, String image, String played, String points, String team, String winlose) {
        Calculation = calculation;
        this.image = image;
        this.played = played;
        this.points = points;
        this.team = team;
        this.winlose = winlose;
    }
    public String getCalculation() {
        return Calculation;
    }
    public void setCalculation(String calculation) {
        Calculation = calculation;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getPlayed() {
        return played;
    }
    public void setPlayed(String played) {
        this.played = played;
    }
    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getWinlose() {
        return winlose;
    }
    public void setWinlose(String winlose) {
        this.winlose = winlose;
    }
    @Override
    public int compareTo(groupainheret o) {
        int s=Integer.parseInt(o.getPoints()) - Integer.parseInt(this.points);
        int r=Integer.parseInt(o.getCalculation()) - Integer.parseInt(this.Calculation);
        if(o.getPoints().compareTo(this.points)<0)
            return s;
        else if(o.getPoints().compareTo(this.points)==0||o.getCalculation().compareTo(this.Calculation)>0)
            return r;
        else return 0;
    }
}
