package algorithmtoolbox.w4;

import java.util.*;
import java.io.*;

public class W4E2_MajorityElement {
    private static int getMajorityElementMooreVotingAlgorithm(int[] a) {
        // Select candidate (If the array have the majority element, then the candidate is always this majority element)
        // because major_count >= n/2 + 1
        int maj_index = 0;
        int count = 1;
        int candidate = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = a[i];
                count = 1;
            }
        }

        // Check if the candidate_count >= n/2 + 1
        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }
        if (count > Math.floor((double) a.length / 2)) return 1;

        return -1;
    }

    private static int getMajorityElementSorting(int[] a) {
        Arrays.sort(a);
        int i = 1;
        while (i < a.length) {
            int count = 1;
            while (i < a.length && a[i] == a[i - 1]) {
                i++;
                count++;
            }

            if (count > Math.floor((double) a.length / 2)) return 1;
            i++;
        }

        return -1;
    }

    private static int getMajorityElementDivideAndConquer(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int num = getTheMostFrequentNumber(a, low, high);

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) {
                count++;
            }
        }

        if (count > Math.floor((double) a.length / 2)) return 1;
        else return -1;
    }

    private static int getTheMostFrequentNumber(int[] a, int low, int high) {
        if (low == high) {
            return a[low];
        }

        int mid = low + (high - low) / 2;
        int left = getTheMostFrequentNumber(a, low, mid);
        int right = getTheMostFrequentNumber(a, mid + 1, high);

        if (left == right) {
            return left;
        }

        // Count left and right frequent
        int countLeft = 0, countRight = 0;
        for (int j : a) {
            if (j == left) countLeft++;
            if (j == right) countRight++;
        }

        // Choose left and right for return
        if (countLeft > countRight) return left;
        else return right;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElementDivideAndConquer(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

