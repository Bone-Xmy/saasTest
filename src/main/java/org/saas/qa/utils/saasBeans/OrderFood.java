package org.saas.qa.utils.saasBeans;

public class OrderFood {
	private String foodName;
	private String foodUnit;
	
	public void setFoodName(String foodName){
		this.foodName = foodName;
	}
	public void setFoodUnit(String foodUnit){
		this.foodUnit = foodUnit;
	}
	
	public String getFoodName(){
		return this.foodName;
	}
	public String getFoodUnit(){
		return this.foodUnit;
	}
}
