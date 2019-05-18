package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class CFiveTransportations {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        long n=sc.nextLong();
        long[] tab=new long[5];
        for (int i=0;i<5;i++){
            tab[i]=sc.nextLong();
        }
        long min=Long.MAX_VALUE;
        for (int i=0;i<5;i++){
            min=Math.min(min,tab[i]);
        }
        long ans=n/min+(n%min==0? 0:1)+4;
        out.println(ans);
    }
}
