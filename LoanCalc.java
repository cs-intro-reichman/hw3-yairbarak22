// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}
	private static double endBalance(double loan, double rate, int n, double payment) {	
		
		for (int i = 0; i < n; i++) { 
			loan = (loan-payment) * (1 + rate/100);
		}
		return loan;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double pay = (double) loan / n;
		while (endBalance(loan, rate, n, pay) >= 0) {
			pay += epsilon;
			iterationCounter++;
		}
		return pay;
    }
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double low = 0;
		double high = 100000;
		iterationCounter = 0;
		double pay = (double) (high + low) / 2;	
		while ((high-low) > epsilon) {
			if (endBalance(loan, rate, n, pay) > 0) low = pay;
			else high = pay;
			pay = (double) (high + low) / 2;	
			iterationCounter++;
			}
		
		return pay;
    }
}