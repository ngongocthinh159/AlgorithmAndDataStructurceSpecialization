package algorithmtoolbox.w2;

import java.math.BigInteger;
import java.util.*;

public class W2E5_FibonacciHuge {
    private static long getMod(long n, long m) {
        long length = get_pisano_period(m);
        long newModIndex = n%length;

        return calc_fib(newModIndex).mod(BigInteger.valueOf(m)).longValue();
    }

    private static BigInteger calc_fib(long n) {
        if (n == 1)
            return new BigInteger("1", 10);
        if (n == 0)
            return new BigInteger("0", 10);

        BigInteger[] fibonacci = new BigInteger[(int) n + 1];

        fibonacci[0] = new BigInteger("0", 10);
        fibonacci[1] = new BigInteger("1", 10);
        for (int i = 2; i < n + 1; i++) {
            fibonacci[i] = new BigInteger(String.valueOf(fibonacci[i - 1].add(fibonacci[i - 2])), 10);
        }

        return fibonacci[(int) n];
    }

    public static long get_pisano_period(long m) {
        long length = 0;
        long prev = 0, curr = 1, next = (prev + curr) % m;
        for (int i = 0; i < m*m; i++) {
            next = (prev + curr) % m;
            prev = curr;
            curr = next;
            if (prev%m == 0 && curr%m == 1) {
                length = i + 1;
                return length;
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getMod(n, m));
    }
}

