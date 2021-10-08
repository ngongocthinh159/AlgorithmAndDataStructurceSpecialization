package algorithmtoolbox.w4;

import java.io.*;
import java.util.*;

public class W4E3_ImprovingQuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int x = a[l]; // Pivot
        int j = l; // Initial first index of no-greater than x sequent

        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }

        // Swap the pivot with j
        int t = a[l];
        a[l] = a[j];
        a[j] = t;

        int m2 = j;

        for (int i = l; i <= j - 1; i++) {
            if (a[i] == x) {
                int temp = a[i];
                a[i] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }

        int m1 = j;

        int[] m = {m1, m2};

        return m;
    }

    private static int[] partition3_2(int[] a, int l, int r) {
        //write your code here
        int x = a[l]; // Pivot
        int pivot_ind = l;
        int count = 1;

        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                int t = a[i];
                a[i] = a[i - count];
                a[i - count] = t;
                pivot_ind++;
            } else if (a[i] > x) {
                int t = a[i];
                a[i] = a[r];
                a[r] = t;
                r--;
                i--;
            } else {
                count++;
                pivot_ind++;
            }
        }

        int m2 = pivot_ind;
        int m1 = pivot_ind - count + 1;

        int[] m = {m1, m2};

        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        //use partition3
        int[] m = partition3_2(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

