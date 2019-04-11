package com.happy.board.usebean;

public class ConvertDate {
	
	private String date;
	
	
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getDateChange(){
		// Date date
		// SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-DD");
		// String dateToString = simple.format(date);
		return date.substring(0, date.indexOf(" "));
	}
}
