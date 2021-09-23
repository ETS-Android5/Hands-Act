package com.handshands.handsaast;

public class playerinformation implements Comparable<playerinformation> {
    String assist,goal,image,name,pos;

    public playerinformation() {
    }

    public playerinformation(String assist, String goal, String image, String name) {
        this.assist = assist;
        this.goal = goal;
        this.image = image;
        this.name = name;
    }

    public playerinformation(String assist, String goal, String image, String name, String pos) {
        this.assist = assist;
        this.goal = goal;
        this.image = image;
        this.name = name;
        this.pos = pos;
    }
    public String getAssist() {
        return assist;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public int compareTo(playerinformation o) {
        int s=Integer.parseInt(o.getGoal()) - Integer.parseInt(this.goal);
        int r=Integer.parseInt(o.getAssist()) - Integer.parseInt(this.assist);
        if(o.getGoal().compareTo(this.goal)<0)
        return s;
        else if(o.getGoal().compareTo(this.goal)==0||o.getAssist().compareTo(this.assist)>0)
            return r;
        else return 0;
    }
}
