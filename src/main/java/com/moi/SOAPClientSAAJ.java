/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moi;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

/**
 *
 * @author MOI
 */
public class SOAPClientSAAJ {

    private PostRequest requestDataArray = null;

    public void createSoapEnvelopeInitPayment(SOAPMessage soapMessage) throws SOAPException {
        //System.out.println("-----------------------------7---------createSoapEnvelopeInitPayment--------------");
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "def";
        String myNamespaceURI = "http://www.moi.gov.kw/Services/PayGateService/V1/Definitions";
        String myNamespace1 = "moih";
        String myNamespaceURI1 = "http://www.moi.gov.kw/Common/V1/MoiHeader";
        String myNamespace2 = "wsse";
        String myNamespaceURI2 = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
        String myNamespace3 = "wsu";
        String myNamespaceURI3 = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

        // SOAP Envelope
        //System.out.println("-----------------------------8-----------------------");
        SOAPEnvelope envelope = soapPart.getEnvelope();
        //System.out.println("-----------------------------9-----------------------");
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        //System.out.println("-----------------------------10-----------------------");
        envelope.addNamespaceDeclaration(myNamespace1, myNamespaceURI1);
        //System.out.println("-----------------------------10---------0--------------");
        SOAPHeader soapHeader = envelope.getHeader();
        //System.out.println("-----------------------------10--------00---------------");

        SOAPHeaderElement security = soapHeader.addHeaderElement(new QName(myNamespaceURI2, "Security", myNamespace2));
        security.addAttribute(new QName(myNamespaceURI2, "mustUnderstand", "soapenv"), "0");

        security.addNamespaceDeclaration("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        security.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

        //System.out.println("-----------------------------10------------1-----------");
        SOAPElement soapHeaderElem1 = security.addChildElement("UsernameToken", myNamespace2);
        soapHeaderElem1.addAttribute(new QName(myNamespaceURI3, "Id", "wsu"), "UsernameToken-6E7F82F20833FD165316396362254181");

        //System.out.println("-----------------------------10------------2-----------");
        SOAPElement soapHeaderElem2 = soapHeaderElem1.addChildElement("Username", myNamespace2);
        //System.out.println("-----------------------------10---------------3--------");
        soapHeaderElem2.addTextNode("MOISAHELTESTWSUser");
        //System.out.println("-----------------------------10-----------------4------");
        SOAPElement soapHeaderElem3 = soapHeaderElem1.addChildElement("Password", myNamespace2);
        soapHeaderElem3.addAttribute(new QName("Type"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest");
        //System.out.println("-----------------------------10---------------5--------");
        soapHeaderElem3.addTextNode("ey+hn0nb9mpEbhhZ7M0qZk7u3zY=");
        SOAPElement soapHeaderElem4 = soapHeaderElem1.addChildElement("Nonce", myNamespace2);
        soapHeaderElem4.addAttribute(new QName("EncodingType"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");

        //System.out.println("-----------------------------10--------6---------------");
        soapHeaderElem4.addTextNode("cMlDW0fnanjXbcLKNiJc0Q==");
        SOAPElement soapHeaderElem5 = soapHeaderElem1.addChildElement("Created", myNamespace3);
        //System.out.println("-----------------------------10------7-----------------");
        soapHeaderElem5.addTextNode("2021-12-16T06:30:25.414Z");
        SOAPElement soapHeaderElem6 = soapHeader.addChildElement("MoiHeader", myNamespace1);
        SOAPElement soapHeaderElem7 = soapHeaderElem6.addChildElement("Entity");
        soapHeaderElem7.addTextNode("MOI");
        SOAPElement soapHeaderElem8 = soapHeaderElem6.addChildElement("Department");
        soapHeaderElem8.addTextNode("IT");
        SOAPElement soapHeaderElem9 = soapHeaderElem6.addChildElement("Application");
        soapHeaderElem9.addTextNode("SHLPAYVIEW");
        SOAPElement soapHeaderElem10 = soapHeaderElem6.addChildElement("Requestor");
        soapHeaderElem10.addTextNode(requestDataArray.getInitiatePaymentRequest().getCivilId());

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        //System.out.println("-----------------------------11-----------------------");
        SOAPElement soapBodyElem = soapBody.addChildElement("InitiatePaymentRequest", myNamespace);
        //System.out.println("-----------------------------12-----------------------");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("civilId");
        soapBodyElem1.addTextNode(requestDataArray.getInitiatePaymentRequest().getCivilId());
        //System.out.println("-----------------------------13-----------------------");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("totalPayAmt");
        soapBodyElem2.addTextNode(requestDataArray.getInitiatePaymentRequest().getTotalPayAmt());
        //System.out.println("-----------------------------14-----------------------");
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("contactInfo");
        //System.out.println("-----------------------------15-----------------------");
        SOAPElement soapBodyElem4 = soapBodyElem3.addChildElement("emailId");
        SOAPElement soapBodyElem5 = soapBodyElem3.addChildElement("mobile");
        soapBodyElem5.addTextNode("00000000");
        //System.out.println("-----------------------------16-----------------------");
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("language");
        soapBodyElem6.addTextNode(requestDataArray.getInitiatePaymentRequest().getLanguage());
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("currency");
        soapBodyElem7.addTextNode("KWD");
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("channelID");
        soapBodyElem8.addTextNode("4");
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("paymentMethod");
        soapBodyElem9.addTextNode("1");
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("serviceType");
        soapBodyElem10.addTextNode(requestDataArray.getInitiatePaymentRequest().getServiceType());
        SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("paymentList");

        SOAPElement soapBodyElem12 = soapBodyElem11.addChildElement("number");
        soapBodyElem12.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getItemNumber());
        SOAPElement soapBodyElem13 = soapBodyElem11.addChildElement("year");
        soapBodyElem13.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getYear());
        SOAPElement soapBodyElem14 = soapBodyElem11.addChildElement("amount");
        soapBodyElem14.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getAmount());
        SOAPElement soapBodyElem15 = soapBodyElem11.addChildElement("descriptionEn");
        soapBodyElem15.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getDescriptionEn());
        SOAPElement soapBodyElem16 = soapBodyElem11.addChildElement("descriptionAr");
        soapBodyElem16.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getDescriptionAr());
        SOAPElement soapBodyElem17 = soapBodyElem11.addChildElement("field1");
        soapBodyElem17.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField1());
        SOAPElement soapBodyElem18 = soapBodyElem11.addChildElement("field2");
        soapBodyElem18.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField2());
         SOAPElement soapBodyElem19 = soapBodyElem11.addChildElement("field3");
        soapBodyElem19.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField1());
        SOAPElement soapBodyElem20 = soapBodyElem11.addChildElement("field4");
        soapBodyElem20.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField2());
         SOAPElement soapBodyElem21 = soapBodyElem11.addChildElement("field5");
        soapBodyElem21.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField1());
        SOAPElement soapBodyElem22 = soapBodyElem11.addChildElement("field6");
        soapBodyElem22.addTextNode(requestDataArray.getInitiatePaymentRequest().getPaymentList()[0].getField2());

    }

    public SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, PostRequest requestDataArray) {
        SOAPMessage soapResponse = null;
        try {

            System.out.println("---------beginning of sending soap request 3---------------");
            if (requestDataArray != null) {
                setRequestDataArray(requestDataArray);

            }
            System.out.println("---------beginning of sending soap request 4---------------");
            System.out.println("-----------------------------1-----------------------");
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            System.out.println("-----------------------------2-----------------------");
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            System.out.println("-----------------------------3-----------------------");
            // Send SOAP Message to SOAP Server
            soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
            soapConnection.close();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
        }
        return soapResponse;
    }

    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        System.out.println("-----------------------------4-----------------------");
        MessageFactory messageFactory = MessageFactory.newInstance();
        System.out.println("-----------------------------5-----------------------");
        SOAPMessage soapMessage = messageFactory.createMessage();
        System.out.println("-----------------------------6-----------------------");

        createSoapEnvelopeInitPayment(soapMessage);

        System.out.println("-----------------------------17-----------------------");
        MimeHeaders headers = soapMessage.getMimeHeaders();
        System.out.println("-----------------------------18-----------------------");
        headers.addHeader("SOAPAction", soapAction);
        System.out.println("-----------------------------19-----------------------");

        soapMessage.saveChanges();
        System.out.println("-----------------------------20-----------------------");
        /* Print the request message, just for debugging purposes */
       System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

    /**
     * @return the requestDataArray
     */
    public PostRequest getRequestDataArray() {
        return requestDataArray;
    }

    /**
     * @param requestDataArray the requestDataArray to set
     */
    public void setRequestDataArray(PostRequest requestDataArray) {
        this.requestDataArray = requestDataArray;
    }

}
