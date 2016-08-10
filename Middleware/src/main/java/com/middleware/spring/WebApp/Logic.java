package com.middleware.spring.WebApp;


public class Logic {
	

	//consider the total number of customers who have rated too. [imp]
	
	
	//using Bayesian average to compare the 5-start rating. Total Transaction is compared by computing the ratio of the sales of the 
	//individual service provider with the total sales of the e-commerce website.[his sales to the total sales]. Same for the total 
	// number of transactions.
	
	private static double bayesian_estimator(double Avg_rating,/*consideration c,*/ int num_of_people ){
		int C= 15; // no of people rating required to get to the a-priori mean
		double a_priori_mean = 2.75;
		//int num_of_people;
		double rating_value = (C*a_priori_mean + Avg_rating*num_of_people)/(C+num_of_people); // max value 5
		return rating_value;
	}
	
	private static float transaction_estimator(double total_transc, int num_transc){
		float trans_discount = 0;
		int C = 15;
		double a_priori_mean = 500;
		trans_discount = (float) ((C*a_priori_mean + total_transc*num_transc)/(C+num_transc));
		trans_discount = trans_discount/1000;
		trans_discount = (trans_discount > 10 )? 10 : trans_discount; 
		return trans_discount;
	}
	
	private static float combine(double transaction_value, double rating_value){
		float discount = 0;
		discount = (float) (transaction_value + rating_value);
		//discount = discount*10;
		return discount;
	}
	//implement the consideration factor
	
	public static DiscountObject discount(DiscountObject discount){
		double total_transc = discount.getSpTotalTransactionAMount();
		int num_transc = discount.getSpNumberOfTransaction();
		double Avg_rating=discount.getAvg_rating();
		int num_of_people=discount.getNum_of_people();
		
		if(Avg_rating < 2 || num_of_people < 100 || total_transc < 500 || num_transc < 10){
			discount.setDiscount(0);
		}
		else{
		double rating_discount = bayesian_estimator(Avg_rating, num_of_people);
		//System.out.println(rating_discount);
		double trans_discount = transaction_estimator(total_transc, num_transc);
		discount.setDiscount(combine(trans_discount*2, rating_discount*2));
		System.out.println("tr" + trans_discount);
		System.out.println( "ra" + rating_discount);
		}
		return  discount;
	}
	
	
	
}
