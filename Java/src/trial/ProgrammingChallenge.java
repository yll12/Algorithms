package trial;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class ProgrammingChallenge {

    static void OutputMostPopularDestination(int count, Scanner in) {
        Hashtable<String, Integer> destinationSearched = new Hashtable<String, Integer>();
        String next = "";
        for (int i = 0; i < count; i++) {
            next = in.nextLine();
            if (destinationSearched.containsKey(next)) {
                destinationSearched.put(next, destinationSearched.get(next) + 1);
            } else {
                destinationSearched.put(next, 1);
            }
        }
        int max = Collections.max(destinationSearched.values());
         for (String destination : destinationSearched.keySet()) {
            if (destinationSearched.get(destination) == max) {
                System.out.println(destination);
                return;
            }
        }
    }
    
    static void OutputCommonManager(int count, Scanner in) {
        String firstEmployee = in.nextLine();
        String secondEmployee = in.nextLine();
        String[][] manageRelation = new String[count - 1][2];
        for (int i = 0; i < count - 1; i++) {
            manageRelation[i] = in.nextLine().split(" ");
        }
        String result = OutputCommonManagerHelper(firstEmployee, 
                secondEmployee, manageRelation, count);
        System.out.println(result);
    }
    
    static String OutputCommonManagerHelper(String firstEmployee, String secondEmployee
            , String[][] managerRelations, int count) {
        String first = "";
        String second = "";
        for (int i = 0; i < count - 1; i++) {
            if (managerRelations[i][1].equals(firstEmployee)) {
                if (!first.equals("")) {
                    first = managerRelations[i][0];
                } else {
                    second = managerRelations[i][0];
                }
            } else if (managerRelations[i][1].equals(secondEmployee)) {
                if (!first.equals("")) {
                    first = managerRelations[i][0];
                } else {
                    second = managerRelations[i][0];
                }
            }
        } 
        if (first.equals(second)) {
            return first;
        }
        return OutputCommonManagerHelper(first, second, managerRelations, count);
    }
}
