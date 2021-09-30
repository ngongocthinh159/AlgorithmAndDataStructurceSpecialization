package w3;

import com.google.common.collect.Ordering;

import java.util.*;

public class W3E7_LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        String[] copy = new String[a.length];

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.charAt(0), o2.charAt(0));
            }
        });

        List<Box> boxList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            boxList.add(new Box(i, 0, 0, 0, 0));
        }

        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
            switch (a[i].charAt(0)) {
                case '1':
                    if (boxList.get(1).getLengthOfMaxLength() < a[i].length()) boxList.get(1).setLengthOfMaxLength(a[i].length());
                    boxList.get(1).setEndIndex(i);
                    boxList.get(1).setLength(boxList.get(1).getLength() + 1);
                    break;
                case '2':
                    if (boxList.get(2).getLengthOfMaxLength() < a[i].length()) boxList.get(2).setLengthOfMaxLength(a[i].length());
                    boxList.get(2).setEndIndex(i);
                    boxList.get(2).setLength(boxList.get(2).getLength() + 1);
                    break;
                case '3':
                    if (boxList.get(3).getLengthOfMaxLength() < a[i].length()) boxList.get(3).setLengthOfMaxLength(a[i].length());
                    boxList.get(3).setEndIndex(i);
                    boxList.get(3).setLength(boxList.get(3).getLength() + 1);
                    break;
                case '4':
                    if (boxList.get(4).getLengthOfMaxLength() < a[i].length()) boxList.get(4).setLengthOfMaxLength(a[i].length());
                    boxList.get(4).setEndIndex(i);
                    boxList.get(4).setLength(boxList.get(4).getLength() + 1);
                    break;
                case '5':
                    if (boxList.get(5).getLengthOfMaxLength() < a[i].length()) boxList.get(5).setLengthOfMaxLength(a[i].length());
                    boxList.get(5).setEndIndex(i);
                    boxList.get(5).setLength(boxList.get(5).getLength() + 1);
                    break;
                case '6':
                    if (boxList.get(6).getLengthOfMaxLength() < a[i].length()) boxList.get(6).setLengthOfMaxLength(a[i].length());
                    boxList.get(6).setEndIndex(i);
                    boxList.get(6).setLength(boxList.get(6).getLength() + 1);
                    break;
                case '7':
                    if (boxList.get(7).getLengthOfMaxLength() < a[i].length()) boxList.get(7).setLengthOfMaxLength(a[i].length());
                    boxList.get(7).setEndIndex(i);
                    boxList.get(7).setLength(boxList.get(7).getLength() + 1);
                    break;
                case '8':
                    if (boxList.get(8).getLengthOfMaxLength() < a[i].length()) boxList.get(8).setLengthOfMaxLength(a[i].length());
                    boxList.get(8).setEndIndex(i);
                    boxList.get(8).setLength(boxList.get(8).getLength() + 1);
                    break;
                case '9':
                    if (boxList.get(9).getLengthOfMaxLength() < a[i].length()) boxList.get(9).setLengthOfMaxLength(a[i].length());
                    boxList.get(9).setEndIndex(i);
                    boxList.get(9).setLength(boxList.get(9).getLength() + 1);
                    break;
                default:
                    break;
            }
        }

        int[] count = new int[11];
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            final char c = copy[i].charAt(copy[i].length() - 1);
            switch (copy[i].charAt(0)) {
                case '1':
                    num = boxList.get(1).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '2':
                    num = boxList.get(2).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += c;
                            count[i]++;
                        }
                    }
                    break;
                case '3':
                    num = boxList.get(3).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += c;
                            count[i]++;
                        }
                    }
                    break;
                case '4':
                    num = boxList.get(4).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '5':
                    num = boxList.get(5).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '6':
                    num = boxList.get(6).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '7':
                    num = boxList.get(7).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '8':
                    num = boxList.get(8).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                case '9':
                    num = boxList.get(9).getLengthOfMaxLength() - copy[i].length();
                    if (num > 0) {
                        for (int k = 0; k < num; k++) {
                            copy[i] += '0';
                        }
                    }
                    break;
                default:
                    break;
            }        
        }

        Integer[] a2 = new Integer[a.length];
        List<Integer> copy2 = new ArrayList<>();
        for (int i = 0; i < copy.length; i++) {
            a2[i] = Integer.parseInt(a[i]);
            copy2.add(Integer.valueOf(copy[i]));
        }

        Arrays.sort(a2, Ordering.explicit(copy2));

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
        System.out.println(count[3]);
        System.out.println(count[4]);
        System.out.println(count[5]);

//        for (int i = 1; i <= 9; i++) {
//            if (boxList.get(i).getLength() > 1) {
//                Arrays.sort(copy, boxList.get(i).getEndIndex() - boxList.get(i).getLength() + 1, boxList.get(i).getEndIndex() + 1, new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
//                    }
//                });
//            }
//        }

        for (String j : a) {
            System.out.println(j);
        }

        for (Box i : boxList) {
            System.out.println("Val: " + i.getValue() + " start: " + (i.getEndIndex() - i.getLength() + 1) + " end: " + (i.getEndIndex() + " length: " + i.getLength() + " lengthofmax: " + i.getLengthOfMaxLength()));
        }

        for (int i = copy.length - 1; i >= 0; i--) {
            result += copy[i];
        }

        result = result.replaceAll("0", "");

        return result.toString();
    }

    static class Box {
        private int value;
        private int startIndex;
        private int endIndex;
        private int length;
        private int lengthOfMaxLength;

        Box(int value, int startIndex, int endIndex, int length, int lengthOfMaxLength) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.value = value;
            this.length = length;
            this.lengthOfMaxLength = lengthOfMaxLength;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setLengthOfMaxLength(int lengthOfMaxLength) {
            this.lengthOfMaxLength = lengthOfMaxLength;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getValue() {
            return value;
        }

        public int getLength() {
            return length;
        }

        public int getLengthOfMaxLength() {
            return lengthOfMaxLength;
        }
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

