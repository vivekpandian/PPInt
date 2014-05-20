package com.paypal.exercise.main;

import static com.paypal.exercise.util.IOUtil.print;
import static com.paypal.exercise.util.IOUtil.readLine;

import java.io.IOException;
import java.util.List;

import com.paypal.exercise.AmortizationCalculator;
import com.paypal.exercise.util.AmortizationSchedulePrinter;
import com.paypal.exercise.view.AmortizationSchedule;

/**
 * Driver Class for Amortization Schedule. This class accepts amount, annual %,
 * term (no of years) from the user and prints the Amortization schedule on the
 * console in table format
 * 
 * @author Vivek_Subburam
 * 
 */
public class Main {

	public static final String ENTER_POSITIVE_INTEGER = "Please enter a positive value between ";
	public static final String IO_EXCEPTION_OCCURED = "An IOException was encountered. Terminating program.\n";
	public static final String INVALID_VALUE_ENTERED = "An invalid value was entered.\n";
	public static final String UNABLE_TO_PROCESS_VALUES = "Unable to process the values entered. Terminating program.\n";

	public static final String ENTER_AMOUNT = "Please enter the amount you would like to borrow: ";
	public static final String ENTER_ANNUAL_PERCENTAGE = "Please enter the annual percentage rate used to repay the loan: ";
	public static final String ENTER_TERM_IN_YEARS = "Please enter the term, in years, over which the loan is repaid: ";

	public static void main(String[] args) {

		String[] userPrompts = { ENTER_AMOUNT, ENTER_ANNUAL_PERCENTAGE,
				ENTER_TERM_IN_YEARS };

		String line = "";
		double amount = 0;
		double apr = 0;
		int years = 0;

		for (int i = 0; i < userPrompts.length;) {
			String userPrompt = userPrompts[i];
			try {
				line = readLine(userPrompt);
			} catch (IOException e) {
				print(IO_EXCEPTION_OCCURED);
				return;
			}

			boolean isValidValue = true;
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (AmortizationCalculator.isValidBorrowAmount(amount) == false) {
						isValidValue = false;
						double range[] = AmortizationCalculator
								.getBorrowAmountRange();
						print(ENTER_POSITIVE_INTEGER + range[0] + " and "
								+ range[1] + ". ");
					}
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (AmortizationCalculator.isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = AmortizationCalculator.getAPRRange();
						print(ENTER_POSITIVE_INTEGER + range[0] + " and "
								+ range[1] + ". ");
					}
					break;
				case 2:
					years = Integer.parseInt(line);
					if (AmortizationCalculator.isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = AmortizationCalculator.getTermRange();
						print(ENTER_POSITIVE_INTEGER + range[0] + " and "
								+ range[1] + ". ");
					}
					break;
				}
			} catch (NumberFormatException e) {
				isValidValue = false;
			}
			if (isValidValue) {
				i++;
			} else {
				print(INVALID_VALUE_ENTERED);
			}
		}

		try {
			AmortizationCalculator as = new AmortizationCalculator(amount, apr,
					years);
			List<AmortizationSchedule> amortizationSchedules = as.findAmortizationSchedule();
			AmortizationSchedulePrinter.printAmortizationScheduleOnConsole(amortizationSchedules);
		} catch (IllegalArgumentException e) {
			print(UNABLE_TO_PROCESS_VALUES);
		}
	}

}
