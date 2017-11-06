package com.brianphiri.soapConsume;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {
    public GetCountryResponse getCountryResponse(String countryName){
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws", request, new SoapActionCallback("http://localhost:8080/ws"));
        return response;
    }
}
