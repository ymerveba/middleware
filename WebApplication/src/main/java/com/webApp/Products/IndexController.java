package com.webApp.Products;

import java.io.PrintWriter;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webApp.Check_Out.Cart;
import com.webApp.DAO.Transaction;
import com.webApp.Domain.DiscountResponseObject;
import com.webApp.Domain.RequestBuilder;
import com.webApp.Login.LoginForm;

@Controller
public class IndexController {

	@RequestMapping("/welcomepage")
	public String welcomepage(final Model model, HttpSession session) {
try{
		if (session.getAttribute("items") == null) {
			List<Items> list = ExtractProductData.getProductInfo();
			session.setAttribute("items", list);
			model.addAttribute("items", list);
		}
		if (session.getAttribute("cart") == null)
			model.addAttribute("cart", new Cart());
		else
			model.addAttribute("cart", session.getAttribute("cart"));
		/*if(null!=session.getAttribute("User")){
		model.addAttribute("User", (LoginForm)session.getAttribute("User"));
		}*/
		return "welcomepage";
}catch(Exception e){
	return "failure";
}
	}

	@RequestMapping("/Checkout")
	public String cartvalues(@Valid @ModelAttribute Cart cart,
			BindingResult result, final Model model, HttpSession session,HttpServletRequest request) {
		// @SuppressWarnings("unchecked")
		try{session=request.getSession();
		List list = (List) session.getAttribute("items");
		if (null != session.getAttribute("User")) {
			List<Items> checkoutItems = new ArrayList<Items>();
			List<String> cartList = cart.getCartlist();
			System.out.println(cartList);
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				Items it = (Items) list.get(i);
				for (int j = 0; j < cartList.size(); j++) {
					if (Integer.parseInt(cartList.get(j)) == it.getProductID()) {
						checkoutItems.add(it);
						sum += it.getPrice();
					}
				}
			}
			session.setAttribute("cartList",checkoutItems);
			model.addAttribute("total", sum);
			model.addAttribute("cartList", checkoutItems);
			return "cartdisplay";

		} else {
			session.setAttribute("cart", cart);
			return "redirect:login";

		}
		}catch(Exception e){
			return "failure";
		}
	}

	// unable to marshal type "com.webApp.Domain.DiscountRequestObject"
	// as an element because it is missing an @XmlRootElement annotation]
	@RequestMapping("/AvailDiscount")
	public String purchase(final Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		RequestBuilder requestOffers = new RequestBuilder();
		PrintWriter out = null;
		String result = "";
		DiscountResponseObject discount = null;
		try {
			response.setContentType("text/html");
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");

			System.out.println("Here");

			out = response.getWriter();
			// JSONArray arrayObj = new JSONArray();
			

			response.setContentType("text/html");
			LoginForm loginDetails = (LoginForm) session.getAttribute("User");
			Transaction totalAmount = ExtractProductData
					.getTotalTransactions(loginDetails);
			if(totalAmount==null){
				totalAmount =new Transaction();
				totalAmount.setUser_id(loginDetails.getUserID());
				totalAmount.setNumberOfTransactions(0);
			totalAmount.setTotal_amt(0);}
			session.setAttribute("transaction", totalAmount);
			 discount = requestOffers.getOffer(
					loginDetails, totalAmount);
			 if(!discount.getMessage().equalsIgnoreCase("NO DISCOUNT")){
			
				double discountpercent = discount.getDiscount();
				result += discountpercent + ";";
				double price = CalculateDiscount(discountpercent,
						request.getParameter("discountTotal"));
				result += price;
				out.println(result);
				out.close();
			 }else {
				result+=0+";";
				result+=request.getParameter("discountTotal");
				out.println(result);
				out.close();
			}
			
			
		} catch (Exception e) {
			
			result+=0+";";
			result+=request.getParameter("discountTotal");
			out.println(result);
			out.close();
		}
		

		return "cartdisplay";
	}
	@RequestMapping("/checkOUT")
	public String addTransactions(final Model model, HttpSession session, HttpServletRequest request){
		try{
		session=request.getSession();
		List<Items> list = (List)session.getAttribute("cartList");
		String discount= request.getParameter("discountValue");
		Transaction t;
		if(discount.equals("0")){
			LoginForm loginDetails = (LoginForm) session.getAttribute("User");
			t = ExtractProductData
					.getTotalTransactions(loginDetails);
			discount=request.getParameter("total");
		}
		
		else{
		t=(Transaction) session.getAttribute("transaction");
		}
		t.setTotal_amt(t.getTotal_amt()+Double.parseDouble(discount));
		LoginForm user=(LoginForm) session.getAttribute("User");
		
		t.setUser_id(user.getUserID());
		ExtractProductData.putTransactionDetails(list, t);
		session.removeAttribute("cart");
				return "confirm";
		}catch(Exception e){
			return "faliure";
		}
		
	}

	private double CalculateDiscount(double discountpercent, String total) {
		double discountedprice = 0;
		double tot;
		tot = Double.parseDouble(total);
		discountedprice = tot - (discountpercent * tot / 100);
		return discountedprice;
	}

}
