package com.handshands.handsaast;

public class valorantknockoutmodel {
    String firstimage,firstteam,result,secondteam,secondimage;

    public valorantknockoutmodel() {
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstteam() {
        return firstteam;
    }

    public void setFirstteam(String firstteam) {
        this.firstteam = firstteam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSecondteam() {
        return secondteam;
    }

    public void setSecondteam(String secondteam) {
        this.secondteam = secondteam;
    }

    public String getSecondimage() {
        return secondimage;
    }

    public void setSecondimage(String secondimage) {
        this.secondimage = secondimage;
    }

    public valorantknockoutmodel(String firstimage, String firstteam, String result, String secondteam, String secondimage) {
        this.firstimage = firstimage;
        this.firstteam = firstteam;
        this.result = result;
        this.secondteam = secondteam;
        this.secondimage = secondimage;
    }
}
