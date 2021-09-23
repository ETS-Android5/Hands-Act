package com.handshands.handsaast;

public class matchesvalorantmodel {
    String firstname,secname,groupname,result,live,firstimage,secimage,id,chat,date,map,scoretable,win;

    public matchesvalorantmodel() {
    }

    public matchesvalorantmodel(String firstname, String secname, String groupname, String result, String live, String firstimage, String secimage, String id, String chat, String date, String map, String scoretable, String win) {
        this.firstname = firstname;
        this.secname = secname;
        this.groupname = groupname;
        this.result = result;
        this.live = live;
        this.firstimage = firstimage;
        this.secimage = secimage;
        this.id = id;
        this.chat = chat;
        this.date = date;
        this.map = map;
        this.scoretable = scoretable;
        this.win = win;
    }

    public matchesvalorantmodel(String firstname, String secname, String groupname, String result, String live, String firstimage, String secimage, String id, String chat, String date, String map, String scoretable) {
        this.firstname = firstname;
        this.secname = secname;
        this.groupname = groupname;
        this.result = result;
        this.live = live;
        this.firstimage = firstimage;
        this.secimage = secimage;
        this.id = id;
        this.chat = chat;
        this.date = date;
        this.map = map;
        this.scoretable = scoretable;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getScoretable() {
        return scoretable;
    }

    public void setScoretable(String scoretable) {
        this.scoretable = scoretable;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
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

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
