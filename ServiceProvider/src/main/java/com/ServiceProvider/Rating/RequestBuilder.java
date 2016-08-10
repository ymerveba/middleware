package com.ServiceProvider.Rating;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.RestTemplate;

import com.ServiceProvider.Domain.UserServices;
import com.ServiceProvider.login.LoginForm;


public class RequestBuilder {
	 /*public static final String SERVER_URI = "http://localhost:9080/Middleware";*/
	public static final String SERVER_URI = "http://169.254.222.221:9080/Middleware";
	 public static final String GET_RATING = "/getRating";
	 public static final String SET_RATING = "/setRating";
public static RatingResponseObject buildRequestToGetRatings(List<String> SP_emailID){
	 RestTemplate restTemplate = new RestTemplate();
	 RatingRequestObject request=new RatingRequestObject();
     request.setEmails(SP_emailID);
     request.setPassword("passw0rd");
     request.setServiceProviderID("Service.com");
     RatingResponseObject response = restTemplate.postForObject(SERVER_URI+GET_RATING, request, RatingResponseObject.class);
	return response;
}
public static int addrating(UserServices rating) {
	RestTemplate restTemplate = new RestTemplate();
	SetRatingRequestObject request=new SetRatingRequestObject();
    request.setRated(rating.getRating());
    request.setServiceProvider("Service.com");
    request.setPassword("passw0rd");
    request.setSpEmail(rating.getSpEmail());
    Integer response = restTemplate.postForObject(SERVER_URI+SET_RATING, request, Integer.class);   
	return response;
	
}
}
