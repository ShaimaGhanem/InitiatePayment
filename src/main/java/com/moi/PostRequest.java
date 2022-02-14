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
    "initiatePaymentRequest": {
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
    }
}*/
public class PostRequest {

    private RequestSource requestSource = null;
    private InitiatePaymentRequest initiatePaymentRequest = null;

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
     * @return the initiatePaymentRequest
     */
    public InitiatePaymentRequest getInitiatePaymentRequest() {
        return initiatePaymentRequest;
    }

    /**
     * @param initiatePaymentRequest the initiatePaymentRequest to set
     */
    public void setInitiatePaymentRequest(InitiatePaymentRequest initiatePaymentRequest) {
        this.initiatePaymentRequest = initiatePaymentRequest;
    }

}
