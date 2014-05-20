package com.paypal.exercise;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.paypal.exercise.AmortizationCalculator;
import com.paypal.exercise.util.AmortizationSchedulePrinter;
import com.paypal.exercise.view.AmortizationSchedule;

public class AmortizationCalculatorTest {

	@Test
	public void findAmortizationScheduleForValidData1() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(1000, 1, 1);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		assertNotNull (amortizationSchedules);
		assertEquals (amortizationSchedules.size(),12);
		assertEquals (amortizationSchedules.get(0).getPaymentAmmount(),83.79,0.0);
		assertEquals (amortizationSchedules.get(11).getPaymentAmmount(),83.75,0.0);
	}
	
	@Test
	public void findAmortizationScheduleForValidData2() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(1000, 0.2, 1);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		assertNotNull (amortizationSchedules);
		assertEquals (amortizationSchedules.size(),13);
		assertEquals (amortizationSchedules.get(0).getPaymentAmmount(),83.42,0.0);
		assertEquals (amortizationSchedules.get(12).getPaymentAmmount(),0.05,0.0);
	}	


	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData1() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(1000, 0, 1);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData2() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(1000, 1, 0);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData3() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(0, 1, 1);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData4() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(0, 0, 1);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}		
	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData5() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(1000, 0, 0);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void findAmortizationScheduleForInValidData6() {
		
		AmortizationCalculator amortizationCalculator = new AmortizationCalculator(0, 0, 0);
		List<AmortizationSchedule> amortizationSchedules = amortizationCalculator.findAmortizationSchedule();
		//assertNotNull (findAmortizationSchedule);
	
	}				
}
