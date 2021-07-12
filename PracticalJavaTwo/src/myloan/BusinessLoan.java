package myloan;

/**
 * A public class that extends Loan. The BusinessLoan constructor sets the
 * interest rate to 1% over the current prime interest rate.
 *
 * @author takuya hasama
 * @version Apache NetBeans IDE 12.2
 * @version Java: 15.0.2; Java HotSpot(TM) 64-Bit Server VM 15.0.2+7-27
 */
public class BusinessLoan extends Loan {

    /**
     * A default constructor
     */
    public BusinessLoan() {
        loanNumber = 1;
        customerLastName = "shota";
        amountOfLoan = 50000;
        interestRate = 0.01;
        term = SHORTTERM;
    }

    /**
     *
     * @param loanNumber
     * @param customerLastName
     * @param amountOfLoan
     * @param term
     */
    public BusinessLoan(int loanNumber, String customerLastName, int amountOfLoan, String term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.amountOfLoan = amountOfLoan;
        interestRate = 0.01;
        this.term = term;

    }
}
