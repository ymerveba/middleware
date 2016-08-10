package com.middleware.spring.ServiceProvider;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceProviderController {
	public static final String GET_RATING = "/getRating";
	public static final String SET_RATING = "/setRating";
	private static final Logger logger = Logger
			.getLogger(ServiceProviderController.class);

	@RequestMapping(value = GET_RATING, method = RequestMethod.POST)
	public @ResponseBody RatingResponseObject getRating(
			@RequestBody RatingRequestObject request) {
		RatingResponseObject response = new RatingResponseObject();
		try{
			if(request.getEmails().size()!=0||null!=request.getEmails()){
		logger.info("Start getRating." + request.getEmails());
		LoginForm sp=new LoginForm();
		sp.setEmail_id(request.getServiceProviderID());
		sp.setPassword(request.getPassword());
		//if(null!=DetailsFromDatabase.authenticate(sp));
		
		List<Rating> rating = new ArrayList<Rating>();
		for (int i = 0; i < request.getEmails().size(); i++) {
			rating.add(DetailsFromDatabase
					.getRating(request.getEmails().get(i)));
		}
		response.setRating(rating);
		logger.info("response"+response.getRating().get(0).getRating());
		response.setServiceProvider(request.getServiceProviderID());
		logger.info(response.getServiceProvider());}
			else{
				response.setRating(null);
				response.setServiceProvider(request.getServiceProviderID());
			}
		}catch(Exception e){
			response.setServiceProvider(request.getServiceProviderID());
			response.setRating(null);
			return response;
		}
		return response;
	}

	@RequestMapping(value = SET_RATING, method = RequestMethod.POST)
	public @ResponseBody Integer setRating(
			@RequestBody SetRatingRequestObject request) {
		int response;
		try{logger.info("Start setRating." + request.getRated());
		//SetRatingRequestObject response = new SetRatingRequestObject();
		Rating rating = DetailsFromDatabase.getRating(request.getSpEmail());
		
		logger.info(rating.getId());
		if(rating.getId()==0){
			logger.info("I am empty");
			rating=new Rating();
			//rating.setId(0);
			rating.setNumberOfRatings(1);
			rating.setRating(request.getRated());
			rating.setSP_email(request.getSpEmail());
		rating.setNumberOfRatings(1);
		 response=DetailsFromDatabase.setRating(rating);
		}
		else{
			//DetailsFromDatabase.deleteentry(rating);
		rating.setRating((request.getRated() + (rating.getRating() * rating
				.getNumberOfRatings())) / (rating.getNumberOfRatings() + 1));
		logger.info("data"+rating.getRating());
		rating.setNumberOfRatings(rating.getNumberOfRatings()+1);
		 response=DetailsFromDatabase.updateRating(rating);
		}
		logger.info("data"+rating.getNumberOfRatings());
		
		logger.info(response+"response");}catch(Exception e){ return null;}
		return response;
	}
}
