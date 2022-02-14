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
/*{
    "requestSource": {
        "applicationName": "",
        "requestorCivilId": ""
    },
    "InitiatePaymentResponse": {
        "statusCode": "",
        "statusMessage": "",
        "civilId": "",
        "paymentUrl": "https://kpaytest.com.kw/kpg/paymentpage.htm?PaymentID=100202203596543300"
    }
}*/

public class PostResponse {
    
    private RequestSource requestSource = null;
    private InitiatePaymentResponse initiatePaymentResponse = null;

    /**
     * @return the requestSource
     */
    public RequestSource getRequestSource() {
        return requestSource;
    }

    /**
     * @param requestSource the requestSource to set
     */
    public void setRequestSource(RequestSource requestSource) {
        this.requestSource = requestSource;
    }

    /**
     * @return the initiatePaymentResponse
     */
    public InitiatePaymentResponse getInitiatePaymentResponse() {
        return initiatePaymentResponse;
    }

    /**
     * @param initiatePaymentResponse the initiatePaymentResponse to set
     */
    public void setInitiatePaymentResponse(InitiatePaymentResponse initiatePaymentResponse) {
        this.initiatePaymentResponse = initiatePaymentResponse;
    }
    
}
