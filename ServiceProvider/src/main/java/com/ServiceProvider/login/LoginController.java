package com.ServiceProvider.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ServiceProvider.DAO.DetailsFromDatabase;
import com.ServiceProvider.Domain.ProviderAndService;
import com.ServiceProvider.Domain.Services;
import com.ServiceProvider.Domain.UserServices;
import com.ServiceProvider.Rating.Rating;
import com.ServiceProvider.Rating.RequestBuilder;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")
	private String displayLogin(HttpServletRequest request, final Model model,HttpSession session) {
		try{session=request.getSession();
		if(null==session.getAttribute("User"))
		model.addAttribute("loginForm", new LoginForm());
		else{
			model.addAttribute("loginForm",( LoginForm)session.getAttribute("User"));
			return "redirect:loginValidation";
		}
		return ("login");}
		catch(Exception e){
			return "failure";
		}
	}

	@Autowired
	private LoginFormValidator loginValidator;

	public void setLoginForm(LoginFormValidator loginValidation) {
		this.loginValidator = loginValidation;
	}

	@RequestMapping(value = "/loginValidation")
	private String setModelTermsAndConditions(@Valid LoginForm loginForm,
			final BindingResult result, final Model model, HttpSession session,HttpServletRequest request) {
		// System.out.println("here");
		
try{
		loginValidator.validate(loginForm, result);

		if (result.hasErrors()) {
			model.addAttribute("loginForm", loginForm);
			return ("login");
		} else {

			loginForm = DetailsFromDatabase.authenticate(loginForm, session);
			if (loginForm != null) {

				session.setAttribute("User", loginForm);
				return (DisplayDashboard(loginForm, model,request));
			}
			return ("redirect:login");
		}}
catch(Exception e){
	return "failure";
}
	}

	@RequestMapping(value = "/getServiceProvider")
	public String getServiceProvider(final Model model,HttpServletRequest request) {
	//	HttpSession session =request.getSession(true);
		//List<Services> services=(List<Services>) session.getAttribute("services");
		try{int service_id=Integer.parseInt(request.getParameter("serviceID"));
		model.addAttribute("serviceID",service_id);
		List<ProviderAndService> providers=new ArrayList<ProviderAndService>();
		try{
		providers=DetailsFromDatabase.getProvidersFromDB(service_id);
		if(providers==null||providers.isEmpty()){
			model.addAttribute("none", "No Service Provider Found");
			model.addAttribute("serviceProviders", null);
			return "userDashboard";
		}	
		}
		catch(Exception e){
			model.addAttribute("none", "No Service Provider Found");
			model.addAttribute("serviceProviders", null);
			return "userDashboard";
		}
		System.out.println(providers);
	model.addAttribute("none","");
	model.addAttribute("serviceProviders", providers);
			//System.out.println(services+""+service_id);
		return "userDashboard";}
		catch(Exception e){
			return "failure";
			
		}
	}
	@RequestMapping(value="/selectServices")
	public String addServices(Model model,HttpServletRequest request){
		try{HttpSession session=request.getSession();
		int serviceID=Integer.parseInt(request.getParameter("serviceID"));
		int providerID=Integer.parseInt(request.getParameter("serviceProviderID"));
		LoginForm userDetails=(LoginForm)session.getAttribute("User");
		try {
			DetailsFromDatabase.requestService(serviceID,providerID,userDetails);
			model.addAttribute("confirm","Success");
		} catch (SQLException e) {
			model.addAttribute("confirm", "error");
		}
		return "ServiceRequest";}
		catch(Exception e){
			return "failure";
		}
	}
	@RequestMapping(value="/displayServices")
	public String displayService(Model model,HttpServletRequest request){
		try{
			HttpSession session=request.getSession();
		
		LoginForm userDetails=(LoginForm)session.getAttribute("User");
		Map<String,List<UserServices>> map=new HashMap<String, List<UserServices>>();
		try {
			map=DetailsFromDatabase.getServiceOptedAndStatus(userDetails);
			System.out.println(map.get("completed"));
			model.addAttribute("completed", map.get("completed"));
			model.addAttribute("incompleted", map.get("incompleted"));
			model.addAttribute("rated",map.get("rated"));
			model.addAttribute("results", "");
			model.addAttribute("userServices",new UserServices());
		} catch (SQLException e) {
			model.addAttribute("results","No Services Found" );
		}
		return "displayServices";}
		catch(Exception e){
			return "failure";
		}
	}
	@RequestMapping(value="/userDashboard")
	private String DisplayDashboard(LoginForm loginForm, Model model,HttpServletRequest request) {
		try{
			HttpSession session=request.getSession();
		loginForm=(LoginForm) session.getAttribute("User");
		if (loginForm.getRole() == 'u') {
			List<Services> services = DetailsFromDatabase.getServices();
			//model.addAttribute("services", services);
			//HttpSession session =request.getSession(true);
			session.setAttribute("services",services);
			//model.addAttribute("service", new Services());
			return "userDashboard";
		}
		if (loginForm.getRole() == 's') {
			Map<String,List<UserServices>> map=new HashMap<String, List<UserServices>>();
			map=DetailsFromDatabase.getRequests(loginForm);
			System.out.println(map.get("completed"));
			model.addAttribute("completed", map.get("completed"));
			model.addAttribute("incompleted", map.get("incompleted"));
			model.addAttribute("rated",map.get("rated"));
			model.addAttribute("results", "");
			model.addAttribute("userServices",new UserServices());
			return "serviceProviderDashboard";
		} else
			return "redirect:login";
	}
	catch(Exception e){
		return "failure";
	}

	}
	@RequestMapping(value="/changeStatus")
	public String addRating(@Valid UserServices userServiceUpdate,
			final BindingResult result, final Model model, HttpSession session,HttpServletRequest request){
		try{
		System.out.println("result"+userServiceUpdate.getSpEmail());
		
		LoginForm user=(LoginForm) session.getAttribute("User");
		userServiceUpdate.setServiceProvider_id(user.getId());
		userServiceUpdate.setStatus('1');
		
			DetailsFromDatabase.updateService(userServiceUpdate);
		}catch(Exception e){
		return "failure";
		}
		
		
		return "redirect:userDashboard";
		
		
		}
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request,HttpSession session){
		session.removeAttribute("User");
		
		return "redirect:login";
		
	}

}