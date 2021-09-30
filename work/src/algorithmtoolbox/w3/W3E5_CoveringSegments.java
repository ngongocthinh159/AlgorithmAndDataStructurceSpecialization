package algorithmtoolbox.w3;

import java.util.*;

public class W3E5_CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        ArrayList<Integer> pointsList = new ArrayList<>();

        // sort segments
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        int currentIndex = 0;
        Segment currentSegment = new Segment();

        while (currentIndex < segments.length - 1) {
            currentSegment = segments[currentIndex];

            while (currentIndex < segments.length - 1 && currentSegment.end >= segments[currentIndex + 1].start) {
                currentSegment = new Segment(Math.max(currentSegment.start, segments[currentIndex + 1].start), Math.min(currentSegment.end, segments[currentIndex + 1].end));
                currentIndex++;
            }
            pointsList.add(currentSegment.end);
            currentIndex++;
        }

        if (currentSegment.end < segments[segments.length - 1].start) {
            pointsList.add(segments[segments.length - 1].end);
        }

        int[] points = new int[pointsList.size()];

        for (int i = 0; i < pointsList.size(); i++) {
            points[i] = pointsList.get(i);
        }

        return points;
    }

    private static class Segment {
        int start, end;

        Segment() {
            this.start = 0;
            this.end = 0;
        }

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
