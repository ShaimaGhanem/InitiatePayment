/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.moi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@WebServlet("/")
public class InitiatePayment extends HttpServlet {

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //get the required data from the body
            Gson gson = new Gson();
            String soapEndpointUrl;
            String soapAction;
            SOAPClientSAAJ mSOAPClientSAAJ;
            SOAPMessage soapResponse;
            Iterator itr;

            String data;
            
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            data = builder.toString();
            //System.out.println("value of request data is : " + data);
            if(data.length()>0)
            {

            PostRequest requestDataArray = gson.fromJson(data, PostRequest.class);
           
            //use the data to call SOAP Display to get the required output
            /*SG: call the SOAP webservice */
           // if (requestDataArray.length >= 1) {
                //soapEndpointUrl = "http://10.10.1.1:29084/RE002/RESIDENCY_FEES_DISPLAY_SHL";
                soapEndpointUrl = "https://iservices.moi.gov.kw:5299/knet/services/PayGateService";
                soapAction = "http://www.moi.gov.kw/Services/PayGateService/V1/initiatePayment";
                mSOAPClientSAAJ = new SOAPClientSAAJ();

                //System.out.println("before calling callSoapWebService");
                soapResponse = mSOAPClientSAAJ.callSoapWebService(soapEndpointUrl, soapAction, requestDataArray);
                //System.out.println("after calling callSoapWebService");
                //System.out.println(" Response SOAP Message:");
                //soapResponse.writeTo(System.out);
                //System.out.println();

                itr = soapResponse.getSOAPBody().getChildElements();
                PostResponse oResTrue;
                oResTrue = readPaymentData(itr);
                RequestSource requestSource;
                requestSource = new RequestSource();
                requestSource.setApplicationName(requestDataArray.getRequestSource().getApplicationName());
                requestSource.setRequestorCivilId(requestDataArray.getRequestSource().getRequestorCivilId());
                oResTrue.setRequestSource(requestSource);
                //System.out.println(" Value of return code is "+getReturnCode());

                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                String jsonData = gson.toJson(oResTrue);
                PrintWriter out = response.getWriter();

                out.println(jsonData);

          /*  } else {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                String jsonData = "Data Enter in the body is missing need :ResidentCivilID , FeesPeriod and FeesType";
                PrintWriter out = response.getWriter();

                out.println(jsonData);
            }*/
            }else
            {
                 System.err.println("\nThere is no Data in the body of the request\n");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                String jsonData = "There is no Data in the body of the request";
                PrintWriter out = response.getWriter();

                out.println(jsonData);
            }
        } catch (SOAPException ex) {
            Logger.getLogger(InitiatePayment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PostResponse readPaymentData(Iterator itr) {

        String baseURL = "";
        String paymentId;

        Node node = (Node) itr.next();
        PostResponse oResTrue = new PostResponse();
        InitiatePaymentResponse initiatePaymentResponse = new InitiatePaymentResponse();
        String FirstNodeName = node.getNodeName();
        //System.out.println("---1---- :: node name:" + FirstNodeName);
        if (FirstNodeName.equals("InitiatePaymentResponse")) {
            NodeList childNodes = node.getChildNodes();
            int numberOfChilds = childNodes.getLength();
            //System.out.println("---3---- :: number of childs:" + numberOfChilds);//outputparameters  array ...5
            for (int child = 0; child < numberOfChilds; child++) {

                switch (childNodes.item(child).getNodeName()) {
                    case "statusCode":
                        initiatePaymentResponse.setStatusCode(childNodes.item(child).getTextContent());
                        //System.out.println("---6---- :: value of success is " + isSuccess);
                        break;
                    case "statusMessage":
                        initiatePaymentResponse.setStatusMessage(childNodes.item(child).getTextContent());
                        //System.out.println("---6---- :: value of messageAr is " + messageAr);
                        break;
                    case "baseUrl":
                        baseURL = childNodes.item(child).getTextContent();
                        //System.out.println("---6---- :: value of messageEn is " + messageEn);
                        break;
                    case "civilId":
                        initiatePaymentResponse.setCivilId(childNodes.item(child).getTextContent());
                        //System.out.println("---6---- :: value of messageEn is " + messageEn);
                        break;
                    case "params":
                        NodeList paramschildNodes = childNodes.item(child).getChildNodes();
                        int paramsnumberOfChilds = paramschildNodes.getLength();
                        //System.out.println("---3---- :: number of childs:" + numberOfChilds);//outputparameters  array ...5
                        for (int paramChild = 0; paramChild < paramsnumberOfChilds; paramChild++) {
                            //System.out.println("---4---- :: child name  :" + child + " is " + paramschildNodes.item(paramChild).getNodeName());
                            if (paramschildNodes.item(paramChild).getNodeName().equals("paramValue")) {
                                paymentId = paramschildNodes.item(paramChild).getTextContent();
                                initiatePaymentResponse.setPaymentUrl(baseURL + "PaymentID=" + paymentId);

                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        }
        oResTrue.setInitiatePaymentResponse(initiatePaymentResponse);
        return oResTrue;
    }

 
}
