package com.webApp.Domain;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestTemplate;

import com.webApp.DAO.Transaction;
import com.webApp.Login.LoginForm;

public class RequestBuilder {

    /*public static final String SERVER_URI = "http://localhost:8080/Middleware";*/
	public static final String SERVER_URI = "http://169.254.222.221:9080/Middleware";
    public static final String GET_DISCOUNT = "/getDiscount";
	public DiscountResponseObject getOffer(LoginForm Userlogin, Transaction transactionDetails) throws Exception {
		
		 RestTemplate restTemplate = new RestTemplate();
		 
	        DiscountRequestObject request = new DiscountRequestObject();   
	        request.setPassword("passw0rd");  
	        request.setUserID(Userlogin.getUserID());
	        if(null!=transactionDetails){
	        request.setTotalValue(transactionDetails.getTotal_amt());
	        request.setNumberOfTransactions(transactionDetails.getNumberOfTransactions());}
	        request.setWebAppId("webApp");
	        DiscountResponseObject response = restTemplate.postForObject(SERVER_URI+GET_DISCOUNT, request, DiscountResponseObject.class);
	        System.out.println(response.getUserID()+response.getDiscount());
	        return response;
		
	}

}
