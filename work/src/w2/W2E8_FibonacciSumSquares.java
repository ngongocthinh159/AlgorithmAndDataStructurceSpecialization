package w2;

import java.util.*;

public class W2E8_FibonacciSumSquares {
    private static long getFibonacciSumFast(long n) {
        long sum = 1;
        long factorSum = 0;
        long circle = 60;

        // After 60 numbers the last digit will return back it circle
        for (int i = 0; i < circle; i++) {
            factorSum = (factorSum + getFibonacciLastDigitFast(i)) % 10;
        }

        // Add the remain
        sum = factorSum * ((n + 1) / circle);
        long remain = (n + 1) % circle;
        for (int i = 0; i < remain; i++) {
            sum = (sum + getFibonacciLastDigitFast(i)) % 10;
        }

        return sum;
    }

    private static long getFibonacciLastDigitFast(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return (long) Math.pow(current, 2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

