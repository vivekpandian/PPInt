package exercise;

import static exercise.util.IOUtil.printf;
import static exercise.constants.AmortizationConstants.*;

public class AmortizationSchedule {

	private long amountBorrowed = AMMOUNT_BORROWED_DEFAULT; // in cents
	private double apr = APR_DEFAULT;
	private int initialTermMonths = INITIAL_TERM_MONTHS_DEFAULT;

	private double monthlyInterest = MONTHLY_INTEREST_DEFAULT;
	private long monthlyPaymentAmount = MONTHLY_PAYMENT_AMMOUNT_DEFAULT; // in cents

	private static final double[] borrowAmountRange = new double[] { BORROW_RANGE_APR_MIN,
		BORROW_RANGE_APR_MAX };
	private static final double[] aprRange = new double[] { APR_RANGE_MIN, APR_RANGE_MAX };
	private static final int[] termRange = new int[] { TERM_RANGE_MIN, TERM_RANGE_MAX };

	private long calculateMonthlyPayment() {
		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		//
		// Where:
		// P = Principal
		// I = Interest
		// J = Monthly Interest in decimal form: I / (12 * 100)
		// N = Number of months of loan
		// M = Monthly Payment Amount
		//

		// calculate J
		monthlyInterest = apr / MONTHLY_INTEREST_DIVISOR;

		// this is 1 / (1 + J)
		double tmp = Math.pow(1d + monthlyInterest, -1);

		// this is Math.pow(1/(1 + J), N)
		tmp = Math.pow(tmp, initialTermMonths);

		// this is 1 / (1 - (Math.pow(1/(1 + J), N))))
		tmp = Math.pow(1d - tmp, -1);

		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		double rc = amountBorrowed * monthlyInterest * tmp;

		return Math.round(rc);
	}

	// The output should include:
	// The first column identifies the payment number.
	// The second column contains the amount of the payment.
	// The third column shows the amount paid to interest.
	// The fourth column has the current balance. The total payment amount and
	// the interest paid fields.
	public void outputAmortizationSchedule() {
		//
		// To create the amortization table, create a loop in your program and
		// follow these steps:
		// 1. Calculate H = P x J, this is your current monthly interest
		// 2. Calculate C = M - H, this is your monthly payment minus your
		// monthly interest, so it is the amount of principal you pay for that
		// month
		// 3. Calculate Q = P - C, this is the new balance of your principal of
		// your loan.
		// 4. Set P equal to Q and go back to Step 1: You thusly loop around
		// until the value Q (and hence P) goes to zero.
		//

		String formatString = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
		printf(formatString, "PaymentNumber", "PaymentAmount",
				"PaymentInterest", "CurrentBalance", "TotalPayments",
				"TotalInterestPaid");

		long balance = amountBorrowed;
		int paymentNumber = 0;
		long totalPayments = 0;
		long totalInterestPaid = 0;

		// output is in dollars
		formatString = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
		printf(formatString, paymentNumber++, 0d, 0d,
				((double) amountBorrowed) / 100d,
				((double) totalPayments) / 100d,
				((double) totalInterestPaid) / 100d);

		final int maxNumberOfPayments = initialTermMonths + 1;
		while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {
			// Calculate H = P x J, this is your current monthly interest
			long curMonthlyInterest = Math.round(((double) balance)
					* monthlyInterest);

			// the amount required to payoff the loan
			long curPayoffAmount = balance + curMonthlyInterest;

			// the amount to payoff the remaining balance may be less than the
			// calculated monthlyPaymentAmount
			long curMonthlyPaymentAmount = Math.min(monthlyPaymentAmount,
					curPayoffAmount);

			// it's possible that the calculated monthlyPaymentAmount is 0,
			// or the monthly payment only covers the interest payment - i.e. no
			// principal
			// so the last payment needs to payoff the loan
			if ((paymentNumber == maxNumberOfPayments)
					&& ((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
				curMonthlyPaymentAmount = curPayoffAmount;
			}

			// Calculate C = M - H, this is your monthly payment minus your
			// monthly interest,
			// so it is the amount of principal you pay for that month
			long curMonthlyPrincipalPaid = curMonthlyPaymentAmount
					- curMonthlyInterest;

			// Calculate Q = P - C, this is the new balance of your principal of
			// your loan.
			long curBalance = balance - curMonthlyPrincipalPaid;

			totalPayments += curMonthlyPaymentAmount;
			totalInterestPaid += curMonthlyInterest;

			// output is in dollars
			printf(formatString, paymentNumber++,
					((double) curMonthlyPaymentAmount) / 100d,
					((double) curMonthlyInterest) / 100d,
					((double) curBalance) / 100d,
					((double) totalPayments) / 100d,
					((double) totalInterestPaid) / 100d);

			// Set P equal to Q and go back to Step 1: You thusly loop around
			// until the value Q (and hence P) goes to zero.
			balance = curBalance;
		}
	}

	public AmortizationSchedule(double amount, double interestRate, int years)
			throws IllegalArgumentException {

		if ((isValidBorrowAmount(amount) == false)
				|| (isValidAPRValue(interestRate) == false)
				|| (isValidTerm(years) == false)) {
			throw new IllegalArgumentException();
		}

		amountBorrowed = Math.round(amount * 100);
		apr = interestRate;
		initialTermMonths = years * 12;

		monthlyPaymentAmount = calculateMonthlyPayment();

		// the following shouldn't happen with the available valid ranges
		// for borrow amount, apr, and term; however, without range validation,
		// monthlyPaymentAmount as calculated by calculateMonthlyPayment()
		// may yield incorrect values with extreme input values
		if (monthlyPaymentAmount > amountBorrowed) {
			throw new IllegalArgumentException();
		}
	}

	public static boolean isValidBorrowAmount(double amount) {
		double range[] = getBorrowAmountRange();
		return ((range[0] <= amount) && (amount <= range[1]));
	}

	public static boolean isValidAPRValue(double rate) {
		double range[] = getAPRRange();
		return ((range[0] <= rate) && (rate <= range[1]));
	}

	public static boolean isValidTerm(int years) {
		int range[] = getTermRange();
		return ((range[0] <= years) && (years <= range[1]));
	}

	public static final double[] getBorrowAmountRange() {
		return borrowAmountRange;
	}

	public static final double[] getAPRRange() {
		return aprRange;
	}

	public static final int[] getTermRange() {
		return termRange;
	}


}
