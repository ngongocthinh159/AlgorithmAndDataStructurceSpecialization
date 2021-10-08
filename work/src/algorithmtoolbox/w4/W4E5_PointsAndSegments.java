package algorithmtoolbox.w4;

import java.util.Arrays;
import java.util.Scanner;

public class W4E5_PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        Arrays.sort(starts);
        Arrays.sort(ends);

        // Consider 1 point: Total segments = Total LEFT segments not include point + Total RIGHT segments not include point + Total segments has point
        for (int i = 0; i < points.length; i++) {
            // Total RIGHT segments not include point
            int firstIndexGreaterThan = lowerBound(starts, 0, starts.length - 1, points[i]);
            int sumOfRightSeg = 0;
            if (firstIndexGreaterThan != - 1) sumOfRightSeg = (starts.length - 1) - firstIndexGreaterThan + 1;

            // Total LEFT segments not include point
            int lastIndexLessThan = upperBound(ends, 0, ends.length - 1, points[i]);
            int sumOfLeftSeg = 0;
            if (lastIndexLessThan != - 1) sumOfLeftSeg = lastIndexLessThan + 1;

            // Total segments has point = Total segments - Total LEFT segments not include point - Total RIGHT segments not include point
            cnt[i] = starts.length - sumOfRightSeg - sumOfLeftSeg;
        }

        return cnt;
    }

    // Find the first index in array > num
    private static int lowerBound(int[] arr, int l, int r, int num) {
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    // Find last index in array < num
    private static int upperBound(int[] arr, int l, int r, int num) {
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

