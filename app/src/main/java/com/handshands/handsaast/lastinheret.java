package com.handshands.handsaast;

public class lastinheret implements Comparable<lastinheret> {
    String firstname,secname,groupname,result,date,firstimage,secimage,firstplan,secplan,id,chat;

    public lastinheret() {
    }

    public lastinheret(String firstname, String secname, String groupname, String result, String date, String firstimage, String secimage, String firstplan, String secplan, String id, String chat) {
        this.firstname = firstname;
        this.secname = secname;
        this.groupname = groupname;
        this.result = result;
        this.date = date;
        this.firstimage = firstimage;
        this.secimage = secimage;
        this.firstplan = firstplan;
        this.secplan = secplan;
        this.id = id;
        this.chat = chat;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecname() {
        return secname;
    }

    public void setSecname(String secname) {
        this.secname = secname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getSecimage() {
        return secimage;
    }

    public void setSecimage(String secimage) {
        this.secimage = secimage;
    }

    public String getFirstplan() {
        return firstplan;
    }

    public void setFirstplan(String firstplan) {
        this.firstplan = firstplan;
    }

    public String getSecplan() {
        return secplan;
    }

    public void setSecplan(String secplan) {
        this.secplan = secplan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    @Override
    public int compareTo(lastinheret o) {
        return  Integer.parseInt(o.getId())-Integer.parseInt(this.id);
    }
}
