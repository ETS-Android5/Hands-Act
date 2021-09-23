package com.handshands.handsaast;

public class keepersinformation implements Comparable<keepersinformation> {
    String cleansheet,save,image,name,pos;

    public keepersinformation() {
    }

    public keepersinformation(String cleansheet, String save, String image, String name, String pos) {
        this.cleansheet = cleansheet;
        this.save = save;
        this.image = image;
        this.name = name;
        this.pos = pos;
    }

    public String getCleansheet() {
        return cleansheet;
    }

    public void setCleansheet(String cleansheet) {
        this.cleansheet = cleansheet;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
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
    public int compareTo(keepersinformation o) {
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
