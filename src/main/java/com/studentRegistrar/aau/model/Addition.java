package com.studentRegistrar.aau.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Addition {

	@JsonProperty("firstNumber")
	private int firstNumber;
	
	@JsonProperty("secondNumber")
	private int secondNumber;
	
	@JsonProperty("total")
	private int total;

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
}
