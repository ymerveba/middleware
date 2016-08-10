package com.ServiceProvider.login;


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

			
			System.out.println(loginForm.getEmail_id()+"jhbjjh"+loginForm.getPassword());
		//errors.rejectValue("errorMessage", "rejected.errorMessage.value");

			if (loginForm.getEmail_id() == null||loginForm.getEmail_id()=="")
				errors.rejectValue("UserID", "name.required");
			if (loginForm.getPassword() == null||loginForm.getPassword()=="")
				errors.rejectValue("password", "password.required");
			
		}	
		



	

}
