package com.handshands.handsaast;

public class sendrequest {
    String offer,take,uid,code;

    public sendrequest() {
    }

    public sendrequest(String offer, String take, String uid, String code) {
        this.offer = offer;
        this.take = take;
        this.uid = uid;
        this.code = code;
    }

    public  String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        this.take = take;
    }

    public  String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
