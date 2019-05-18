package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class DAlmostAllDivisors {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        loop : while (t>0){
            t--;
            int n=sc.nextInt();
            Integer[] tab=new Integer[n];
            for (int i=0;i<n;i++){
                tab[i]=sc.nextInt();
            }
            Arrays.sort(tab);
            long x=(long)tab[0]*(long)tab[n-1];
            ArrayList<Integer> divs=new ArrayList<>();
            for (long i=2;i*i<=x;i++){
                if (x%i==0){
                    divs.add((int)i);
                    if (i!=x/i){
                        divs.add((int)(x/i));
                    }
                }
            }
            if (divs.size() != n) {
                out.println(-1);
                continue loop;
            }
            for (int i=0;i<n;i++){
                if (x%tab[i]!=0){
                    out.println(-1);
                    continue loop;
                }
            }
            out.println(x);
        }
    }
}
