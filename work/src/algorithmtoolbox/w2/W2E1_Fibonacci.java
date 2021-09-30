package algorithmtoolbox.w2;

import java.math.BigInteger;
import java.util.Scanner;

public class W2E1_Fibonacci {
    private static BigInteger calc_fib(int n) {
        if (n == 1)
            return new BigInteger("1", 10);
        if (n == 0)
            return new BigInteger("0", 10);

        BigInteger[] fibonacci = new BigInteger[n + 1];

        fibonacci[0] = new BigInteger("0", 10);
        fibonacci[1] = new BigInteger("1", 10);
        for (int i = 2; i < n + 1; i++) {
            fibonacci[i] = new BigInteger(String.valueOf(fibonacci[i - 1].add(fibonacci[i - 2])), 10);
        }

        return fibonacci[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
