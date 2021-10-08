package algorithmtoolbox.w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * This is O(n*logn) method to calculate the smallest distance between a set of points
 */

public class W4E6_Closest_nlogn {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }

    /**
     * @return distance between two points
     */
    static double distance(Point point1, Point point2) {
        return Math.hypot(point1.getX() - point2.getX(), point1.getY() - point2.getY());
    }

    static double minimalDistance(int[] x, int[] y) {
        int n = x.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        Arrays.sort(points, (o1, o2) -> {
            if (o1.getX() == o2.getX()) return 0;
            else return o1.getX() > o2.getX() ? 1 : -1;
        });

        return minimalDistanceDivideAndConquer(points, 0, n - 1);
    }

    /**
     * Divide and conquer function
     */
    static double minimalDistanceDivideAndConquer(Point[] points, int l, int r) {
        // Base case number of points = 1
        if (l == r) return -1;
        // Base case (number of points = 2 or 3) => Use brute force to find min, then merge these elements to order of Y increase
        if (r - l + 1 <= 3) {
            // Find min distance
            double minDist = Double.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                for (int j = i + 1; j <= r; j++) {
                    minDist = Math.min(minDist, distance(points[i], points[j]));
                }
            }

            // Merge to order of Y increase
            int mid = l + (r - l) / 2;
            merge(points, l, mid, r);

            return minDist;
        }

        // Recursion
        int mid = l + ((r - l) / 2);
        double left = minimalDistanceDivideAndConquer(points, l, mid);
        double right = minimalDistanceDivideAndConquer(points, mid + 1, r);
        merge(points, l, mid, r);

        double d = Math.min(left, right);

        // Get point inside strip + then sort the strip
        double lineX = points[mid].getX() + (double) (points[mid + 1].getX() - points[mid].getX()) / 2;
        Point[] stripPointsTemp = new Point[r - l + 1];
        int k = 0;
        for (int i = l; i <= r; i++) {
            if (Math.abs(lineX - points[i].getX()) < d) {
                stripPointsTemp[k] = points[i];
                k++;
            }
        }
        Point[] stripPoints = Arrays.copyOfRange(stripPointsTemp, 0, k);

        double d_Prime = Double.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k && (stripPoints[j].getY() - stripPoints[i].getY() < d); j++) {
                d_Prime = Math.min(d_Prime, distance(stripPoints[i], stripPoints[j]));
            }
        }

        return Math.min(d, d_Prime);
    }

    /**
     * This function will merge the sub array follow order of Y increase (using the same merging technique of mergeSort)
     */
    static void merge(Point[] points, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - (m + 1) + 1;

        Point[] leftArr = new Point[n1];
        int k = 0;
        for (int i = l; i <= m; i++) {
            leftArr[k] = points[i];
            k++;
        }

        Point[] rightArr = new Point[n2];
        k = 0;
        for (int i = m + 1; i <= r; i++) {
            rightArr[k] = points[i];
            k++;
        }

        int i = 0, j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (leftArr[i].getY() <= rightArr[j].getY()) {
                points[k] = leftArr[i];
                i++;
            } else {
                points[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            points[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            points[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }

        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
