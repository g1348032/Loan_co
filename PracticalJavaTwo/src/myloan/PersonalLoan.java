package myloan;

/**
 * A public class that extends Loan. The PersonalLoan constructor sets the
 * interest rate to 2% over the current prime interest rate.
 *
 * @author takuya hasama
 * @version Apache NetBeans IDE 12.2
 * @version Java: 15.0.2; Java HotSpot(TM) 64-Bit Server VM 15.0.2+7-27
 */
public class PersonalLoan extends Loan {

    /**
     * A default constructor
     */
    public PersonalLoan() {
        loanNumber = 1;
        customerLastName = "hideo";
        amountOfLoan = 2000;
        interestRate = 0.02;
        term = SHORTTERM;
    }

    /**
     *
     * @param loanNumber
     * @param customerLastName
     * @param amountOfLoan
     * @param term
     */
    public PersonalLoan(int loanNumber, String customerLastName, int amountOfLoan, String term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.amountOfLoan = amountOfLoan;
        interestRate = 0.02;
        this.term = term;

    }

}
