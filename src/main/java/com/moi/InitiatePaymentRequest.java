/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moi;

/**
 *
 * @author MOI
 */
/* "initiatePaymentRequest": {
        "civilId": "",
        "totalPayAmt": "",
        "language": "",
        "serviceType": "",
        "paymentList": [
            {
                "itemNumber": "",
                "year": "",
                "amount": "",
                "descriptionEn": "",
                "descriptionAr": "",
                "field1": "",
                "field2": "",
                "field3": "",
                "field4": "",
                "field5": "",
                "field6": ""
            }
        ]
    }*/
public class InitiatePaymentRequest {

    private String civilId = "";
    private String totalPayAmt = "";
    private String language = "";
    private String serviceType = "";
    private PaymentList[] paymentList = null;

    /**
     * @return the civilId
     */
    public String getCivilId() {
        return civilId;
    }

    /**
     * @param civilId the civilId to set
     */
    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }

    /**
     * @return the totalPayAmt
     */
    public String getTotalPayAmt() {
        return totalPayAmt;
    }

    /**
     * @param totalPayAmt the totalPayAmt to set
     */
    public void setTotalPayAmt(String totalPayAmt) {
        this.totalPayAmt = totalPayAmt;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @return the paymentList
     */
    public PaymentList[] getPaymentList() {
        return paymentList;
    }

    /**
     * @param paymentList the paymentList to set
     */
    public void setPaymentList(PaymentList[] paymentList) {
        this.paymentList = paymentList;
    }

}
