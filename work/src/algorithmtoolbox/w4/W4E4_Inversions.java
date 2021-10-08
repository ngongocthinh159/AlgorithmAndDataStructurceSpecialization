package algorithmtoolbox.w4;

import java.util.*;



public class W4E4_Inversions {
    static int res = 0;

    private static long merge(int[] a, int l, int mid, int r) {
        // Get the length of two merged array
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy the data from initial array to left array
        int k = 0;
        for (int i = l; i <= mid; i++) {
            leftArr[k] = a[i];
            k++;
        }

        // Copy the data from initial array to right array
        k = 0;
        for (int i = mid + 1; i <= r; i++) {
            rightArr[k] = a[i];
            k++;
        }

        // Start to merge left and right array into initial array
        int i = 0, j = 0; // 2 index of two array left and right
        k = l;
        long pairs = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                a[k] = leftArr[i];
                k++;
                i++;
            } else {
                a[k] = rightArr[j];
                k++;
                j++;
                pairs += leftArr.length - i;
            }
        }

        // Copy the remaining of left array and right array (if any)
        while (i < n1) {
            a[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < n2) {
            a[k] = rightArr[j];
            k++;
            j++;
        }

        return pairs;
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);

            res += merge(a, l, mid, r);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        mergeSort(a,0, a.length - 1);
        System.out.println(res);
    }
}

