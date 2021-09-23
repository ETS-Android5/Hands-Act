package com.handshands.handsaast;

public class valorantdetailsmodel implements Comparable<valorantdetailsmodel>{
    String id,leftimage,lefttext,rightimage,righttext;

    public valorantdetailsmodel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeftimage() {
        return leftimage;
    }

    public void setLeftimage(String leftimage) {
        this.leftimage = leftimage;
    }

    public String getLefttext() {
        return lefttext;
    }

    public void setLefttext(String lefttext) {
        this.lefttext = lefttext;
    }


    public String getRightimage() {
        return rightimage;
    }

    public void setRightimage(String rightimage) {
        this.rightimage = rightimage;
    }

    public String getRighttext() {
        return righttext;
    }

    public void setRighttext(String righttext) {
        this.righttext = righttext;
    }

    public valorantdetailsmodel(String id, String leftimage, String lefttext, String rightimage, String righttext) {
        this.id = id;
        this.leftimage = leftimage;
        this.lefttext = lefttext;
        this.rightimage = rightimage;
        this.righttext = righttext;
    }

    @Override
    public int compareTo(valorantdetailsmodel o) {
        return Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}
