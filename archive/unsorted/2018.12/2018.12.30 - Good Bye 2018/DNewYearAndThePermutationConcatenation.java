package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class DNewYearAndThePermutationConcatenation {

    public static int gcdExtended(int a, int b, int x, int y)
    {

        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        int x1 = 1, y1 = 1; // To store results of recursive call
        int gcd = gcdExtended(b % a, a, x1, y1);

        x = y1 - (b / a) * x1;
        y = x1;

        return gcd;
    }

    static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1)
            return 0;
        while (a > 1)
        {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n = sc.nextInt();
        long[] tab = new long[1000005];
        tab[0] = 0L;
        tab[1] = 1L;
        for (int i = 2; i < 1000005; i++) {
            tab[i] = (tab[i - 1] * i) % 998244353;
        }
        long ans = 0;
        long tmp;
        for (int i = n - 1; i > 1; i--) {
            tmp = tab[i] - 1;
            tmp *= (tab[n - 1] * modInverse((int)tab[i],998244353));
            tmp %= 998244353;
            ans += tmp;
            ans %= 998244353;
        }
        out.println((ans * n + tab[n]) % 998244353);

    }
}
