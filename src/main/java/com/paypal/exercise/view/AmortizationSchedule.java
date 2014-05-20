package com.paypal.exercise.view;

import java.io.Serializable;

public class AmortizationSchedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8197025132257849346L;

	private int paymentNumber;
	private double paymentAmmount;
	private double paymentInterest;
	private double currentBalance;
	private double totalPayments;
	private double totalInterestPaid;

	public AmortizationSchedule() {

	}

	public AmortizationSchedule(int paymentNumber, double paymentAmmount,
			double paymentInterest, double currentBalance,
			double totalPayments, double totalInterestPaid) {
		
		this.paymentNumber = paymentNumber;
		this.paymentAmmount = paymentAmmount;
		this.paymentInterest = paymentInterest;
		this.currentBalance = currentBalance;
		this.totalPayments = totalPayments;
		this.totalInterestPaid = totalInterestPaid;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public double getPaymentAmmount() {
		return paymentAmmount;
	}

	public void setPaymentAmmount(double paymentAmmount) {
		this.paymentAmmount = paymentAmmount;
	}

	public double getPaymentInterest() {
		return paymentInterest;
	}

	public void setPaymentInterest(double paymentInterest) {
		this.paymentInterest = paymentInterest;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getTotalPayments() {
		return totalPayments;
	}

	public void setTotalPayments(double totalPayments) {
		this.totalPayments = totalPayments;
	}

	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}

}
