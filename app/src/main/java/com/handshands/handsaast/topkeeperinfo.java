package com.handshands.handsaast;

public class topkeeperinfo implements Comparable<topkeeperinfo> {
    String name,pos,save,cleansheet,image;

    public topkeeperinfo() {
    }

    public topkeeperinfo(String name, String pos, String save, String cleansheet, String image) {
        this.name = name;
        this.pos = pos;
        this.save = save;
        this.cleansheet = cleansheet;
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

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getCleansheet() {
        return cleansheet;
    }

    public void setCleansheet(String cleansheet) {
        this.cleansheet = cleansheet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int compareTo(topkeeperinfo o) {
        int s=Integer.parseInt(o.getCleansheet()) - Integer.parseInt(this.cleansheet);
        int r=Integer.parseInt(o.getSave()) - Integer.parseInt(this.save);
        if(o.getCleansheet().compareTo(this.cleansheet)<0)

            return s;
        else if(o.getCleansheet().compareTo(this.cleansheet)==0||o.getSave().compareTo(this.save)>0)
            return r;
        else
            return 0;
    }
}
