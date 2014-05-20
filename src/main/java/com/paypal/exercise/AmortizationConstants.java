package com.paypal.exercise;

public class AmortizationConstants {
	
	private AmortizationConstants () { }
	
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
	
	
	
	public static final String AMORTZ_TBL_HDR_FMT_STR = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
	public static final String AMORTZ_TBL_OUT_FMT_STR = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
	
	
}
