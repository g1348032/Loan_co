
package myloan;

import java.io.Serializable;

/**
 * A public abstract class that implements the LoanConstants interface.
 *
 * @author takuya hasama
 * @version Apache NetBeans IDE 12.2
 * @version Java: 15.0.2; Java HotSpot(TM) 64-Bit Server VM 15.0.2+7-27
 */
public abstract class Loan implements LoanConstants, Comparable<Loan>, Serializable {

    public int loanNumber;
    public String customerLastName;
    public int amountOfLoan;
    public double interestRate;
    public String term;

    /**
     * A default constructor
     */
    public Loan() {

    }

    /**
     * A Loan includes a loan number, customer last name, amount of loan,
     * interest rate, and term. The constructor requires data for each of the
     * fields except interest rate.
     *
     * @param loanNumber
     * @param customerLastName
     * @param amountOfLoan
     * @param term
     */
    public Loan(int loanNumber, String customerLastName, int amountOfLoan, String term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.amountOfLoan = amountOfLoan;
        this.term = term;

    }

    /**
     *
     * @param compareLoan
     * @return none
     */
    @Override
    public int compareTo(Loan compareLoan) {

        // Here when we compare if both the variables are equal return 0
        if (this.term.equals(compareLoan.term)) {
            return 0;
            // If first one is bigger than the latter return 1
        } else if (this.term.compareTo(compareLoan.term) > 0) {
            return 1;
            // else return 0
        } else {
            return -1;
        }
    }

    /**
     * Override the toString() method to display the loan data.
     *
     * @paramn none
     * @return display all the loans.
     */
    @Override
    public String toString() {
        return "loanNumber :" + loanNumber + "\t\t\tcustomerLastName :" + customerLastName
                + "\t\t\tamountOfLoan :" + amountOfLoan + "\t\t\tinterestRate :" + interestRate + "\t\t\tterm :" + term + " Year";
    }

}
