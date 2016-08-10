package com.ServiceProvider.Rating;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ServiceProvider.DAO.DetailsFromDatabase;
import com.ServiceProvider.Domain.ProviderAndService;
import com.ServiceProvider.Domain.UserServices;
import com.ServiceProvider.login.LoginForm;


@Controller
public class RatingController {
@RequestMapping(value="/rateSP")
public String addRating(@Valid UserServices userServiceUpdate,
		final BindingResult result, final Model model, HttpSession session,HttpServletRequest request){
	try{System.out.println("result"+userServiceUpdate.getSpEmail());
	
	LoginForm user=(LoginForm) session.getAttribute("User");
	userServiceUpdate.setUser_id(user.getId());
	Rating rating=new Rating();
	
	int rated=RequestBuilder.addrating(userServiceUpdate);
	if(rated==1){
		userServiceUpdate.setStatus('2');
	try {
		DetailsFromDatabase.updateService(userServiceUpdate);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	return "redirect:displayServices";}
	catch(Exception e){
		return "failure";
	}
	
}
public static List<ProviderAndService> getRating(List<ProviderAndService> providers,List<String> SP_Email) {
	RequestBuilder.buildRequestToGetRatings(SP_Email);
	
	
	return providers;
	
}
}
