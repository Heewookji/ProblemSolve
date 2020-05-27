package p01festival;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testN = sc.nextInt();

        for (int t = 0; t < testN; t++) {

            int dayN = sc.nextInt();
            int leastN = sc.nextInt();
            int[] days = new int[dayN];

            for (int i = 0; i < dayN; i++) {
                days[i] = sc.nextInt();
            }

            double ret = 100;
            for (int i = 0; i + leastN <= days.length; i++) {
                double sum = 0;
                for (int j = i; j < days.length; j++) {
                    sum += days[j];
                    if (j - i + 1 >= leastN)
                        ret = Math.min(ret, sum / (j - i + 1));
                }
            }
            System.out.println(ret);
        }

    }

}