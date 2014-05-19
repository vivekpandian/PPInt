package exercise.constants;

public class AmortizationConstants {
	
	public static final long AMMOUNT_BORROWED_DEFAULT = 0; // in cents
	public static final double APR_DEFAULT = 0d;
	public static final int INITIAL_TERM_MONTHS_DEFAULT = 0;
	
	public static final double MONTHLY_INTEREST_DEFAULT = 0d;
	public static final long MONTHLY_PAYMENT_AMMOUNT_DEFAULT = 0; // in cents
	
	public static final double BORROW_RANGE_APR_MIN = 0.01d;
	public static final double BORROW_RANGE_APR_MAX = 1000000000000d;
	
	public static final double APR_RANGE_MIN = 0.000001d;
	public static final double APR_RANGE_MAX = 100d;
	
	public static final int TERM_RANGE_MIN = 1;
	public static final int TERM_RANGE_MAX = 1000000;
	
	public static final double MONTHLY_INTEREST_DIVISOR = 12d * 100d;
	
	
}
