package com.webApp.Login;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


	@Component("loginFormValidator")
	public class LoginFormValidator implements Validator{

		public boolean supports(Class<?> klass) {
			// TODO Auto-generated method stub
			return LoginForm.class.isAssignableFrom(klass);

		}

		public void validate(Object target, Errors errors) {
         LoginForm loginForm = (LoginForm) target;

			
			System.out.println(loginForm.getUserID()+"jhbjjh"+loginForm.getPassword());
		//errors.rejectValue("errorMessage", "rejected.errorMessage.value");

			if (loginForm.getUserID() == null||loginForm.getUserID()=="")
				errors.rejectValue("UserID", "name.required");
			if (loginForm.getPassword() == null||loginForm.getPassword()=="")
				errors.rejectValue("password", "password.required");
			
		}	
		



	

}
