package algo.hackerrank;

import java.io.*;
import java.util.*;

public class TimeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Time time = new Time(in.nextInt(), in.nextInt());
        System.out.println(time);
    }
}

class Mapper {
    int x;
    Map<Integer, String> map = new HashMap<>();
    
    public Mapper() {
        map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "quarter");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "half");
    }
    
    String mapToString(int x) {
        if (x <= 20 || x == 30) {
            return map.get(x);
        } else if (x < 30) {
            return "twenty " + map.get(x % 10);
        } else if (x < 60) {
            return mapToString(60 - x);
        } else { // Exception case
            return mapToString(x % 60);
        }
    }
    
    String mapToMinutes(int x) {
        if (x == 1) {
            return mapToString(x) + " minute";
        } else if (x == 30 || x == 45 || x == 15) {
            return mapToString(x);
        } else {
            return mapToString(x) + " minutes";
        }
    }
    
}

class Time {
    int H;
    int M;
    
    public Time(int H, int M) {
        this.H = H;
        this.M = M;
    }
    
    @Override
    public String toString() {
        Mapper mapper = new Mapper();
        if (M == 0) {
            return mapper.mapToString(H) + " o' clock";
        }
        
        if (M <= 30) {
            return mapper.mapToMinutes(M) + " past " + mapper.mapToString(H);
        } else {
            return mapper.mapToMinutes(M) + " to " + mapper.mapToString(H + 1);
        }
    }
    
}