package com.middleware.spring.WebApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.middleware.spring.ServiceProvider.LoginForm;


@Controller
public class WebAppController {
	private static final String GET_DISCOUNT="/getDiscount"; 
	private static final Logger logger = LoggerFactory.getLogger(WebAppController.class);
	@RequestMapping(value = GET_DISCOUNT, method = RequestMethod.POST)
	public @ResponseBody WebAppDiscountResponseObject get(@RequestBody WebAppDiscountRequestObject request) {
		logger.info("Start discount.");
		LoginForm loginForm=new LoginForm();
		WebAppDiscountResponseObject response=new WebAppDiscountResponseObject();	
		loginForm.setEmail_id(request.getWebAppId());
		loginForm.setPassword(request.getPassword());
		response.setUserID(loginForm.getEmail_id());
		response.setWebAppId(request.getWebAppId());
		if(null!=DetailsFromDatabase.authenticate(loginForm)){
		DiscountObject details=DetailsFromDatabase.getDiscountDetails(request.getUserID(),loginForm);
		//Add service provider total sales
		details.setSpNumberOfTransaction(request.getNumberOfTransactions());
		details.setSpTotalTransactionAMount(request.getTotalValue());
		if(null==details||details.getAvg_rating()==0){
			response.setDiscount(0); 
			response.setMessage("NO DISCOUNT");
		}
		else{
			logger.info("details"+ details.getString());
			details=Logic.discount(details);
			response.setDiscount(details.getDiscount());
		}
		}
		else{
			response.setDiscount(0); 
			response.setMessage("Your Ecommerce is not registered Please contact Middleware");
		}
		
		
		return response;
	}
}