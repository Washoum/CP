package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class CATaleOfTwoLands {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n = sc.nextInt();
        Integer[] tab = new Integer[n];
        for (int i = 0; i < n; i++) {
            tab[i] = Math.abs(sc.nextInt());
        }
        Arrays.sort(tab);
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int idxr = Arrays.binarySearch(tab, 2 * tab[i]);
            if (idxr < 0) {
                idxr++;
                idxr *= -1;
                idxr--;
            }
            else{
                while (idxr<n-1 && tab[idxr+1].intValue()==tab[idxr]) idxr++;
            }
            if (idxr > i) {
                ans += idxr-i;
            }

        }
        out.println(ans);
    }
}
