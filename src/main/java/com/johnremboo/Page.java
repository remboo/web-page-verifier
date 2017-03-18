package com.johnremboo;

/**
 * Created by Igor on 18.03.2017.
 */
public class Page {
    private String data;
    private boolean isVerified;

    public Page(String data, boolean isVerified) {
        this.data = data;
        this.isVerified = isVerified;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
