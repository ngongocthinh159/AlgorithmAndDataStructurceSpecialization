package w3;

import java.util.*;

public class W3E3_CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentIndex = 0;
        int lastIndex = 0;
        int numberOfRefuse = 0;

        if (dist <= tank) return 0;

        while (currentIndex < stops.length - 1) {
            lastIndex = currentIndex;
            while (currentIndex < stops.length - 1 && stops[currentIndex + 1] - stops[lastIndex] <= tank) {
                currentIndex++;
            }
            if (currentIndex == lastIndex) return -1;
            numberOfRefuse++;
        }

        return numberOfRefuse - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        stops[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n + 1] = dist;

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
