package com.handshands.handsaast;

public class eventsinherent implements Comparable<eventsinherent>{
    String time,day,month, description,id, image;

    public eventsinherent() {
    }
    public eventsinherent(String time, String day, String month, String description, String id, String image) {
        this.time = time;
        this.day = day;
        this.month = month;
        this.description = description;
        this.id = id;
        this.image = image;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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



    @Override
    public int compareTo(eventsinherent o) {
        return Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}