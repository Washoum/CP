package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class Vecteurs {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            int n=sc.nextInt();
            Integer[] a=new Integer[n];
            Integer[] b=new Integer[n];

            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for (int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            long ans1=0,ans2=0;
            for (int i=0;i<n;i++){
                ans1+=(long)a[i]*b[n-i-1];
                ans2+=(long)b[i]*a[n-i-1];
            }
            out.println(Math.min(ans1,ans2));

        }
    }
}
