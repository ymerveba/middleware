package com.middleware.spring.WebApp;

class consideration {
		int rating_percentage;
		public int getRating_percentage() {
			return rating_percentage;
		}

		public void setRating_percentage(int rating_percentage) {
			this.rating_percentage = rating_percentage;
		}

		public int getTotal_transc_percentage() {
			return total_transc_percentage;
		}

		public void setTotal_transc_percentage(int total_transc_percentage) {
			this.total_transc_percentage = total_transc_percentage;
		}

		public int getNum_transc_percentage() {
			return num_transc_percentage;
		}

		public void setNum_transc_percentage(int num_transc_percentage) {
			this.num_transc_percentage = num_transc_percentage;
		}

		int total_transc_percentage;
		int num_transc_percentage;
		
		consideration(int rating_percentage,int total_transc_percentage,int num_transc_percentage){
			this.rating_percentage = rating_percentage;
			this.total_transc_percentage = total_transc_percentage;
			this.num_transc_percentage = num_transc_percentage;
		}
	}
