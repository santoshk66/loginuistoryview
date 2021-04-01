package com.groupsale.Lootlo.models;

public class customer {
    String _id,customerID,firstName,lastName,emailID;
    deal[] leadDeal;
    deal[] currentDeal;
    // left refer schema


    public customer(String _id, String customerID, String firstName, String lastName, String emailID, deal[] leadDeal, deal[] currentDeal) {
        this._id = _id;
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.leadDeal = leadDeal;
        this.currentDeal = currentDeal;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public deal[] getLeadDeal() {
        return leadDeal;
    }

    public void setLeadDeal(deal[] leadDeal) {
        this.leadDeal = leadDeal;
    }

    public deal[] getCurrentDeal() {
        return currentDeal;
    }

    public void setCurrentDeal(deal[] currentDeal) {
        this.currentDeal = currentDeal;
    }
}
