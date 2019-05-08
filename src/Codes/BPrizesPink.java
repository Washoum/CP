package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BPrizesPink {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int a=sc.nextInt();
        int x;
        for (int i=0;i<n;i++){
            x=sc.nextInt();
            out.println(x/a+x%a);
        }
    }
}
