package com.mycompany.overlapping.intervals;

import com.mycompany.overlapping.intervals.Overlapping.Interval;
import java.util.*;

/**
 *
 * @author Denalda
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Overlapping m = new Overlapping();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: \n");
        int size = input.nextInt();

        System.out.print("--------------------------------------------------- \n");

        ArrayList<Interval> x = new ArrayList<>();

        for (int j = 0; j < size; j++) {
            
            System.out.println("Enter the first sequence of the Intervals: ");
             int f1 = input.nextInt();
            
            System.out.println("Enter the second sequence of the Intervals: ");
             int f2 = input.nextInt();

//        x.add(new Interval(1, 3));
//        x.add(new Interval(2, 6));
//        x.add(new Interval(15, 18));
//        x.add(new Interval(17, 20));
            x.add(new Interval(f1, f2));

            x = m.merge(x);

        }
        System.out.print("--------------------------------------------------- \n");
        System.out.println("All overlapping intervals into one :");

        for (Interval i : x) {
            System.out.println(i.getStart() + " " + i.getEnd());
        }
    }
}
