package w2;

import java.util.*;

public class W2E7_FibonacciPartialSum {
    private static long getFibonacciPartialSumFast(long from, long n) {
        long sum = 0;
        long factorSum = 0;
        long circle = 60;

        // After 60 numbers the last digit will return back it circle
        for (int i = 0; i < circle; i++) {
            factorSum = (factorSum + getFibonacciLastDigitFast(i)) % 10;
        }

        if (n - from + 1 < 60) {
            long start = 59 - (((from/circle) + 1) * circle - from) + 1;
            for (long i = start; i <= start + (n - from); i++) {
                sum = (sum + getFibonacciLastDigitFast(i)) % 10;
            }
        } else {
            // Test from 354 -> 424
            long a = from; // 354
            long b = ((from / circle) + 1) * circle - 1; // 359
            long c = n; // 424

            for (int i = 59; i >= 59 - (b - a + 1) + 1; i--) {
                sum = (sum + getFibonacciLastDigitFast(i)) % 10;
            }

            for (int i = 0; i <= c - (c/circle)*circle; i++) {
                sum = (sum + getFibonacciLastDigitFast(i)) % 10;
            }
        }

        return sum;
    }

    private static long getFibonacciLastDigitFast(long n) {
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

