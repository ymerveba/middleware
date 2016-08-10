package com.ServiceProvider.DAO;



import com.ServiceProvider.Rating.Rating;
import com.ServiceProvider.Rating.RequestBuilder;


public class TestRating {

	public static void main(String[] args) {
		Rating r=new Rating();
		r.setRating(4);
		r.setSP_email("b@email.com");
		System.out.println("here");
		try {
			//DetailsFromDatabase.getProvidersFromDB(2);
			//System.out.println(RequestBuilder.addrating(r));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
