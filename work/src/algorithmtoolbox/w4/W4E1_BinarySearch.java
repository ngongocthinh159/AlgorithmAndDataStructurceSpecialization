package algorithmtoolbox.w4;

import java.io.*;
import java.util.*;

public class W4E1_BinarySearch {

    static int binarySearch(int[] a, int x) {
        int low = 0, height = a.length - 1;
        //write your code here

        return binarySearchTemp(a, low, height, x);
    }

    static int binarySearchTemp(int[] a, int low, int height, int x) {
        //write your code here
        if (low <= height) {
            int mid = low + (height - low) / 2;

            if (a[mid] == x) return mid;
            else if (a[mid] > x) return binarySearchTemp(a, low, mid - 1, x);
            else return binarySearchTemp(a, mid + 1, height, x);
        }

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
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
