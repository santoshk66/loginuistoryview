package com.groupsale.Lootlo.models;

public class deal {
    int pinCode,neededSubscriber,dealPrice;
    String dealID,productID,textMessage,dummyName,dummyImageURL,dummyBelowText,dummyTime;
    //left currentSubscriber,creation,count,status,audioMessage


    public deal(int pinCode, int neededSubscriber, int dealPrice, String dealID, String productID, String textMessage, String dummyName, String dummyImageURL, String dummyBelowText, String dummyTime) {
        this.pinCode = pinCode;
        this.neededSubscriber = neededSubscriber;
        this.dealPrice = dealPrice;
        this.dealID = dealID;
        this.productID = productID;
        this.textMessage = textMessage;
        this.dummyName = dummyName;
        this.dummyImageURL = dummyImageURL;
        this.dummyBelowText = dummyBelowText;
        this.dummyTime = dummyTime;
    }

    public deal() {
    }

    public String getDummyName() {
        return dummyName;
    }

    public void setDummyName(String dummyName) {
        this.dummyName = dummyName;
    }

    public String getDummyImageURL() {
        return dummyImageURL;
    }

    public void setDummyImageURL(String dummyImageURL) {
        this.dummyImageURL = dummyImageURL;
    }

    public String getDummyBelowText() {
        return dummyBelowText;
    }

    public void setDummyBelowText(String dummyBelowText) {
        this.dummyBelowText = dummyBelowText;
    }

    public String getDummyTime() {
        return dummyTime;
    }

    public void setDummyTime(String dummyTime) {
        this.dummyTime = dummyTime;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getNeededSubscriber() {
        return neededSubscriber;
    }

    public void setNeededSubscriber(int neededSubscriber) {
        this.neededSubscriber = neededSubscriber;
    }

    public int getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(int dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getDealID() {
        return dealID;
    }

    public void setDealID(String dealID) {
        this.dealID = dealID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
