package com.handshands.handsaast;

public class newsinheret implements Comparable<newsinheret> {
    String date,description,id,image,wideimage;
     String report;
            String title;

    public newsinheret(String date, String description, String id, String image, String wideimage, String report, String title) {
        this.date = date;
        this.description = description;
        this.id = id;
        this.image = image;
        this.wideimage = wideimage;
        this.report = report;
        this.title = title;
    }

    public newsinheret() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWideimage() {
        return wideimage;
    }

    public void setWideimage(String wideimage) {
        this.wideimage = wideimage;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(newsinheret o) {
        return Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}
