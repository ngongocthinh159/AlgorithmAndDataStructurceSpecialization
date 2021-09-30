package algorithmtoolbox.w3;

import java.util.Scanner;

public class W3E1_MoneyChange {
    private static int getChange(int m) {
        int num = 0;

        while (m - 10 >= 0) {
            m -= 10;
            num++;
        }

        while (m - 5 >= 0) {
            m -= 5;
            num++;
        }

        while (m - 1 >= 0) {
            m -= 1;
            num++;
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

