package w2;

import java.util.*;

public class W2E5_FibonacciLastDigit {
    private static int getFibonacciLastDigitFast(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

