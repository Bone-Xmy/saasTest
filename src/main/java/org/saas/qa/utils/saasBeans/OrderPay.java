package org.saas.qa.utils.saasBeans;

public class OrderPay {
	private String paySubjectName;
	private Double debitAmount;
	
	public void setPaySubjectName(String paySubjectName){
		this.paySubjectName = paySubjectName;
	}
	public void setDebitAmount(Double debitAmount){
		this.debitAmount = debitAmount;
	}
	
	public String getPaySubjectName(){
		return this.paySubjectName;
	}
	public Double getDebitAmount(){
		return this.debitAmount;
	}
}
