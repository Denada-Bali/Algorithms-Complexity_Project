package com.mycompany.overlapping.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Denalda
 */
public class Overlapping {

    static class Interval { // Interval is an inner classes of overlapping class which helps us to get start time and end time.
        private int start;   // an Interval has start time and end time
        private int end;
        
        Interval() {            //constructor without parameters  
            start = 0;          // initialize start and end time with 0
            end = 0;
        }

        Interval(int s, int e) { //constructor with two parameters  
            start = s;         
            end = e;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    //the IntervalComparator is an inner class which allow us compering two intervals according to their starting time.
    static class IntervalComparator implements Comparator<Interval> {

        public int compare(Interval interval1, Interval interval2) {
            return interval1.getStart() - interval2.getStart();
        }
    }

    //merge function takes a set of intervals and merges overlapping intervals
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals.size() == 0 || intervals.size() == 1) {   // we check if the both condition are true or false
            return intervals;
        }

        // help us to store and manipulate the group of objects 
        Collections.sort(intervals, new IntervalComparator()); 

        Interval first = intervals.get(0); // get methods which refer to the index number

        int start = first.getStart();
        int end = first.getEnd();

        // create an empty array list of Interval 
        ArrayList<Interval> result = new ArrayList<Interval>();

        // Start from the next interval and merge if necessary
        for (int i = 1; i < intervals.size(); i++) {

            Interval current = intervals.get(i);

            if (current.getStart() <= end) {
                end = getMax(current.getEnd(), end);
            } else {

                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }

        result.add(new Interval(start, end)); 
        return result;
    }

   
    // getMax method help as to take the maximum of two parameters
    public static int getMax(int a, int b) {
        return (a >= b) ? a : b;  // here I have create a condtion with “ternary (expression)” which means 
    //(a >= b) ?  which means “is a smaller than b?”
    // a : b means “If yes, return A, if not, return b”
    }
}
