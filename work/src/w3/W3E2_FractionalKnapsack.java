package w3;

import java.util.*;

public class W3E2_FractionalKnapsack {
    static class Pair {
        private int value;
        private int weight;
        private double fraction;

        public void setValue(int value) {
            this.value = value;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
        public void setFraction(double fraction) {
            this.fraction = fraction;
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        // Create new pair list combines of value, weight, fraction in each pair
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            pairList.add(new Pair());
            pairList.get(i).setValue(values[i]);
            pairList.get(i).setWeight(weights[i]);
            pairList.get(i).setFraction((double) values[i] / weights[i]);
        }

        // Sort the pair list
        pairList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.fraction == o2.fraction) return 0;
                else {
                    return o1.fraction > o2.fraction ? -1 : 1;
                }
            }
        });

        double sumOfValues = 0;
        int weight = 0;
        int i = 0;
        while (weight < capacity && i < pairList.size()) {
            if (weight + pairList.get(i).weight <= capacity) {
                sumOfValues += pairList.get(i).value;
                weight = weight + pairList.get(i).weight;
            } else {
                sumOfValues += (double) (capacity - weight) / pairList.get(i).weight * pairList.get(i).value;
                weight = capacity;
            }
            i++;
        }

        return sumOfValues;
    }



    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
