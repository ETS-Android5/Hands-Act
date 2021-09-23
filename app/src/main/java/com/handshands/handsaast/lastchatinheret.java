package com.handshands.handsaast;

public class lastchatinheret implements Comparable<lastchatinheret> {
    String id,leftimg,lefttext,time,rightimg,righttext;
    public lastchatinheret() {
    }
    public lastchatinheret(String id, String leftimg, String lefttext, String time, String rightimg, String righttext) {
        this.id = id;
        this.leftimg = leftimg;
        this.lefttext = lefttext;
        this.time = time;
        this.rightimg = rightimg;
        this.righttext = righttext;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeftimg() {
        return leftimg;
    }

    public void setLeftimg(String leftimg) {
        this.leftimg = leftimg;
    }

    public String getLefttext() {
        return lefttext;
    }

    public void setLefttext(String lefttext) {
        this.lefttext = lefttext;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRightimg() {
        return rightimg;
    }

    public void setRightimg(String rightimg) {
        this.rightimg = rightimg;
    }

    public String getRighttext() {
        return righttext;
    }

    public void setRighttext(String righttext) {
        this.righttext = righttext;
    }

    @Override
    public int compareTo(lastchatinheret o) {
        return Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}
