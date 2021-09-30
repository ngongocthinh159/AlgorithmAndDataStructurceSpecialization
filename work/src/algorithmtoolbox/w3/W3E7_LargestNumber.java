package algorithmtoolbox.w3;

import java.util.*;

public class W3E7_LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        StringBuilder result = new StringBuilder();

        List<Long> list = new ArrayList<>();

        list.add(Long.parseLong(a[0]));

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (isGreaterOrEqual(list.get(j).toString(), a[i])) {
                    if (j == list.size() - 1) {
                        list.add(Long.parseLong(a[i]));
                        break;
                    }
                } else {
                    list.add(j, Long.parseLong(a[i]));
                    break;
                }
            }
        }

        for (Long aLong : list) {
            result.append(aLong.toString());
        }

        return result.toString();
    }

    public static boolean isGreaterOrEqual(String a, String b) {
        return Long.parseLong(a + b) >= Long.parseLong(b + a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

