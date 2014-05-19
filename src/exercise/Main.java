package exercise;

import static exercise.util.IOUtil.print;
import static exercise.util.IOUtil.readLine;

import java.io.IOException;

/**
 * Driver Class for Amortization Schedule. This class accepts ammount, annual %, term (no of years) from the user and prints the Amortization schedule on the console in table format
 * @author Vivek_Subburam
 *
 */
public class Main {
	
	public static void main(String[] args) {

		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ",
				"Please enter the annual percentage rate used to repay the loan: ",
				"Please enter the term, in years, over which the loan is repaid: " };

		String line = "";
		double amount = 0;
		double apr = 0;
		int years = 0;

		for (int i = 0; i < userPrompts.length;) {
			String userPrompt = userPrompts[i];
			try {
				line = readLine(userPrompt);
			} catch (IOException e) {
				print("An IOException was encountered. Terminating program.\n");
				return;
			}

			boolean isValidValue = true;
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (AmortizationSchedule.isValidBorrowAmount(amount) == false) {
						isValidValue = false;
						double range[] = AmortizationSchedule.getBorrowAmountRange();
						print("Please enter a positive value between "
								+ range[0] + " and " + range[1] + ". ");
					}
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (AmortizationSchedule.isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = AmortizationSchedule.getAPRRange();
						print("Please enter a positive value between "
								+ range[0] + " and " + range[1] + ". ");
					}
					break;
				case 2:
					years = Integer.parseInt(line);
					if (AmortizationSchedule.isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = AmortizationSchedule.getTermRange();
						print("Please enter a positive integer value between "
								+ range[0] + " and " + range[1] + ". ");
					}
					break;
				}
			} catch (NumberFormatException e) {
				isValidValue = false;
			}
			if (isValidValue) {
				i++;
			} else {
				print("An invalid value was entered.\n");
			}
		}

		try {
			AmortizationSchedule as = new AmortizationSchedule(amount, apr,
					years);
			as.outputAmortizationSchedule();
		} catch (IllegalArgumentException e) {
			print("Unable to process the values entered. Terminating program.\n");
		}
	}


}
