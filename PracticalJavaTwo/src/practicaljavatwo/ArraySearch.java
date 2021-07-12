/*
30038637, takuya hasama, 25/05/2021
 */
package practicaljavatwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArraySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            numbers.add((int) (Math.random() * 99) + 1);
        }

        Collections.sort(numbers);
        for (int x : numbers) {
            System.out.println(x);
        }

        boolean found = false;

        while (!found) {
            try {
                System.out.print("Enter a number for search");
                int number = sc.nextInt();
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i).equals(number)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("found from the 10 numbers");
                } else {
                    System.out.println("Not found from the 10 numbers");
                }
            } catch (Exception ex) {
                System.out.println("You made a typo");
                sc.next();
            }
        }

    }
}
