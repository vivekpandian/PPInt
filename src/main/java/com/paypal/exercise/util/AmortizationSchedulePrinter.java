package com.paypal.exercise.util;

import static com.paypal.exercise.AmortizationConstants.AMORTZ_TBL_HDR_FMT_STR;
import static com.paypal.exercise.AmortizationConstants.AMORTZ_TBL_OUT_FMT_STR;
import static com.paypal.exercise.util.IOUtil.printf;

import java.util.List;

import com.paypal.exercise.view.AmortizationSchedule;

/**
 * Helper class to print Amortization schedule
 * @author Vivek_Subburam
 *
 */
public class AmortizationSchedulePrinter {
	


	/**
	 * This method prints the amortizationSchedule
	 * The output should include:
	 * The first column identifies the payment number.
	 * The second column contains the amount of the payment.
	 * The third column shows the amount paid to interest.
	 * The fourth column has the current balance. The total payment amount and
	 * the interest paid fields.
	 * @param amortizationSchedule - model which encapsulates amortization details
	 */
	public static void printAmortizationScheduleOnConsole (List<AmortizationSchedule> amortizationSchedules) {
		//print the header information
		printf(AMORTZ_TBL_HDR_FMT_STR, "PaymentNumber", "PaymentAmount",
				"PaymentInterest", "CurrentBalance", "TotalPayments",
				"TotalInterestPaid");
		
		if (amortizationSchedules != null && amortizationSchedules.size() > 0) {
			for (AmortizationSchedule amortizationSchedule : amortizationSchedules) {
				// output is in dollars
				printf(AMORTZ_TBL_OUT_FMT_STR, amortizationSchedule.getPaymentNumber(),
						amortizationSchedule.getPaymentAmmount(),
						amortizationSchedule.getPaymentInterest(),
						amortizationSchedule.getCurrentBalance(),
						amortizationSchedule.getTotalPayments(),
						amortizationSchedule.getTotalInterestPaid());
			}
		}
		
		
	}
}
