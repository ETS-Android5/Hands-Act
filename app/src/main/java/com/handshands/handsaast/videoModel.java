package com.handshands.handsaast;

public class videoModel implements Comparable<videoModel>{
    String title,picture,link,id;

    public videoModel() {
    }

    public videoModel(String title, String picture, String link, String id) {
        this.title = title;
        this.picture = picture;
        this.link = link;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(videoModel o) {
        return Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}
