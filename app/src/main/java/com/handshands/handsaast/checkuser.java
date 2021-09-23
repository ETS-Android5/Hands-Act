package com.handshands.handsaast;

public class checkuser {
    String description,email,type,uid,phonenumber;

    public checkuser() {
    }

    public checkuser(String description, String email, String type, String uid, String phonenumber) {
        this.description = description;
        this.email = email;
        this.type = type;
        this.uid = uid;
        this.phonenumber = phonenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
