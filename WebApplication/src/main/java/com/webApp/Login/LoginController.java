package com.webApp.Login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ErrorCoded;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webApp.Check_Out.Cart;
import com.webApp.Products.Items;
import com.webApp.Products.Product_Info;


@Controller
public class LoginController {
	@RequestMapping(value="/login")
	private String displayLogin(HttpServletRequest request,final Model model){
	    model.addAttribute("loginForm",new LoginForm());
		return ("login");
	}
	@Autowired
	private LoginFormValidator loginValidator;

	public void setLoginForm(LoginFormValidator loginValidation)
	{
		this.loginValidator=loginValidation;
	}
@RequestMapping(value="/loginValidation")
private String setModelTermsAndConditions(@Valid LoginForm loginForm,final BindingResult result,final Model model,  HttpSession session){
    // System.out.println("here");
     try{
     loginValidator.validate(loginForm,result);
     
if(result.hasErrors()){
	model.addAttribute("loginForm",loginForm);
	return ("login");
}
else {
	
	if(authenticate(loginForm)){
		model.addAttribute("User", loginForm);
	session.setAttribute("User", loginForm);
	Cart cart=(Cart)session.getAttribute("cart");
	if(cart!=null&&cart.getCartlist()!=null&&!cart.getCartlist().isEmpty()){
		List list=(List) session.getAttribute("items");	
	List<Items> checkoutItems=new ArrayList<Items>();
	List<String> cartList= cart.getCartlist();
	System.out.println(cartList);
	int sum=0;
	for (int i=0;i<list.size();i++){
		Items it=(Items) list.get(i);
		for(int j=0;j<cartList.size();j++)
		{
			if(Integer.parseInt(cartList.get(j))==it.getProductID())
		{
			checkoutItems.add(it);
			sum+=it.getPrice();
		}
	}
}
	session.setAttribute("cartList",checkoutItems);
	model.addAttribute("total",sum);
	 model.addAttribute("cartList",checkoutItems);
	return ("cartdisplay"); 
	}
	else return ("redirect:welcomepage");}
	else {
		Errors error=result;
		error.rejectValue("UserID", "name.check");
		error.rejectValue("UserID", "password.check");
		model.addAttribute("loginForm",loginForm);
	return ("login");}
}
	
}catch(Exception e){
	return "failure";
}	 
}
public boolean authenticate(LoginForm loginobj){
	boolean result = false;
	
	@SuppressWarnings("deprecation")
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	
	LoginForm login1 = (LoginForm) session.get(LoginForm.class, loginobj.getUserID());
	if(login1!=null && login1.getPassword().equals(loginobj.getPassword())){
		result = true;
		return result;
	}
	return result;
}
@RequestMapping(value="/logout")
public String logout(HttpServletRequest request,HttpSession session){
	session.removeAttribute("User");
	session.removeAttribute("cart");
	return "redirect:login";
	
}	

}