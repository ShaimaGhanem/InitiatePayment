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
/* "InitiatePaymentResponse": {
        "statusCode": "",
        "statusMessage": "",
        "civilId": "",
        "paymentUrl": "https://kpaytest.com.kw/kpg/paymentpage.htm?PaymentID=100202203596543300"
    }*/
public class InitiatePaymentResponse {
   
    private String statusCode="";
    private String statusMessage="";
    private String civilId="";
    private String paymentUrl="";

    /**
     * @return the statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

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
     * @return the paymentUrl
     */
    public String getPaymentUrl() {
        return paymentUrl;
    }

    /**
     * @param paymentUrl the paymentUrl to set
     */
    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

   
}
