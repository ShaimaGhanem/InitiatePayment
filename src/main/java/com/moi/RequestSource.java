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
/* "requestSource": { 
        "applicationName": "",
        "requestorCivilId": ""
    },*/
public class RequestSource {
   
    private String applicationName="";
    private String requestorCivilId = "";

    /**
     * @return the applicationName
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * @param applicationName the applicationName to set
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * @return the requestorCivilId
     */
    public String getRequestorCivilId() {
        return requestorCivilId;
    }

    /**
     * @param requestorCivilId the requestorCivilId to set
     */
    public void setRequestorCivilId(String requestorCivilId) {
        this.requestorCivilId = requestorCivilId;
    }
   

   
}
