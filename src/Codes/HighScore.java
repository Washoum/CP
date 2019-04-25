package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class HighScore {
    static BigInteger eval(int[] a) {
        BigInteger value = BigInteger.ZERO;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++) {
            BigInteger v = big(a[i]);
            value = value.add(v.multiply(v));
            min = Math.min(min, a[i]);
        }
        return value.add(big(7).multiply(big(min)));
    }

    static BigInteger big(int x) {
        return BigInteger.valueOf(x);
    }


    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int[] a = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int x = sc.nextInt();
            Arrays.sort(a);
            a[a.length - 1] += x;
            BigInteger maxValue = eval(a);
            a[a.length - 1] -= x;
            for (int min = a[0]; min <= 7; min++) {
                int y = x;
                int[] b = Arrays.copyOf(a, a.length);
                for (int j = 0; j < a.length; j++) {
                    int give = Math.max(min - a[j], 0);
                    y -= give;
                    b[j] += give;
                }
                if (y < 0) continue;
                b[b.length - 1] += y;
                BigInteger value = eval(b);
                if (value.compareTo(maxValue) > 0) {
                    maxValue = value;
                }
            }
            out.println(maxValue);
        }
    }
}
