package w3;

import java.util.*;

public class W3E6_DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here

        if (n == 1) {
            summands.add(1);
            return summands;
        }
        if (n == 2) {
            summands.add(2);
            return summands;
        }

        int sum = 0;
        int currentPrize = 1;

        while (sum <= n) {
            sum += currentPrize;
            if (sum <= n) {
                summands.add(currentPrize);
            }
            currentPrize++;
        }
        sum = sum - (currentPrize - 1);

        int last = summands.get(summands.size() - 1);
        if (sum != n) {
            summands.remove(summands.size() - 1);
            summands.add(n - (sum - last));
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

