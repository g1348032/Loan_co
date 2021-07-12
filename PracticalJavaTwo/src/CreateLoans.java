
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import myloan.BusinessLoan;
import myloan.Loan;
import static myloan.LoanConstants.*;
import myloan.PersonalLoan;

/**
 * Description of my information
 *
 * @author takuya hasama, 30038637
 * @version Apache NetBeans IDE 12.2
 * @version Java: 15.0.2; Java HotSpot(TM) 64-Bit Server VM 15.0.2+7-27
 */
public class CreateLoans {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Loan> createLoans = new ArrayList<>();

        /**
         * Description of the object "createLoan" Store several Loan objects in
         * a ArrayList object named "createLoan"
         */
        createLoans.add(new BusinessLoan());
        createLoans.add(new PersonalLoan(2, "hideo", 2000, SHORTTERM));
        createLoans.add(new BusinessLoan(3, "kenji", 100000, LONGTERM));
        createLoans.add(new PersonalLoan(4, "naoko", 40000, LONGTERM));
        createLoans.add(new BusinessLoan(5, COMPANYNAME, 1000, MEDIUMTERM));

        /**
         * Your program sorts the loans by its term with the collections.sort()
         * method createLoans will be listed based on the ascending order.
         */
        Collections.sort(createLoans);
        for (Loan x : createLoans) {
            System.out.println(x.toString());
        }

        /**
         * Prompt the user for the current prime interest rate A search method
         * that searches interest rate Iterate the numbers for search found is
         * initially set to false if found, display FOUND if not found, display
         * NOT FOUND and search interest rate again then, prompt the user for a
         * loan type and all relevant information for that loan
         *
         * @throws InputMismatchException
         */
        boolean foundOne = false;
        boolean foundTwo = false;

        while (!foundOne) {
            try {
                System.out.print("What's your interest rate?");
                Double interest = sc.nextDouble();
                for (int i = 0; i < createLoans.size(); i++) {
                    if (interest.equals(createLoans.get(i).interestRate)) {
                        foundOne = true;
                        break;
                    }
                }
                /**
                 * Do not allow a loan amounts over the maximum specified in the
                 * LoanConatants interface.
                 */
                if (foundOne) {
                    if (interest == 0.01) {
                        System.out.println("Loan type is BusinessLoan");
                        System.out.print("What's your last name?");
                        String name = sc.next();
                        System.out.print("What's the amount of loan? (it must be less than 250000)");
                        int amount = sc.nextInt();
                        while (!foundTwo) {

                            if (amount < MAXIMUMLOANAMOUNT) {
                                System.out.println("it accepted");
                                foundTwo = true;
                                break;
                            } else {
                                System.out.println("The figure is not accepted");
                                System.out.print("What's the amount of loan? (it must be less than 250000)");
                                amount = sc.nextInt();
                            }

                        }
                        System.out.print("What's the term? (choose from 1 Year,3 Year,5 Year)");
                        String term = sc.next();
                        createLoans.add(new BusinessLoan(6, name, amount, term));
                    }
                    if (interest == 0.02) {
                        System.out.println("Loan type is PersonalLoan");
                        System.out.print("What's your last name?");
                        String name = sc.next();
                        System.out.print("What's the amount of loan?");
                        int amount = sc.nextInt();
                        while (!foundTwo) {

                            if (amount < MAXIMUMLOANAMOUNT) {
                                System.out.println("it accepted");
                                foundTwo = true;
                                break;
                            } else {
                                System.out.println("The figure is not accepted");
                                System.out.print("What's the amount of loan? (it must be less than 250000)");
                                amount = sc.nextInt();
                            }
                        }
                        System.out.print("What's the term? (choose from 1 Year,3 Year,5 Year)");
                        String term = sc.next();
                        createLoans.add(new PersonalLoan(6, name, amount, term));
                    }

                } else {
                    System.out.println("The figure is not accepted");
                }
            } catch (InputMismatchException I) {
                System.out.println(I);
                System.out.print("What's your interest rate?");
                Double interest = sc.nextDouble();
            }
        }

        /**
         * Your program stores the collection object in a binary file. Use the
         * Seriallizable interface Make binary file "CreatedLoan.bin" According
         * to output stream, save the object in the binary file Close the file
         * Catch if IO exceptions happen
         *
         * @throws IOException
         */
        System.out.println("Writing to file...");
        try {
            FileOutputStream fileOut = new FileOutputStream("CreatedLoan.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(createLoans);
            fileOut.close();
            System.out.println("Completed - CreatedLoan.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        /**
         * Your program reads the object from the binary file "CreatedLoan.bin"
         * and display the contents on the screen Make empty for the object read
         * from binary file According to input stream, read an object as
         * Arraylist Close the file catch if IO exceptions happen Handle
         * ClassNotFound exception Displays the objects
         *
         * @throws IOException
         * @throws ClassNotFoundException
         *
         */
        System.out.println("Reading from file...");
        ArrayList<Loan> em = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream("CreatedLoan.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            em = (ArrayList) objectIn.readObject();
            fileIn.close();
        } catch (IOException err) {
            System.err.println(err);
        } catch (ClassNotFoundException err) {
            System.err.println(err);
        }

        Collections.sort(createLoans);
        for (Loan x : createLoans) {
            System.out.println(x.toString());
        }

    }
}
