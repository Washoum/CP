package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ETwoArraysAndSumOfFunctions {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        Long[] a=new Long[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextLong()*(long)(i+1)*(long)(n-i);
        }
        Integer[] b=new Integer[n];
        for (int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        Arrays.sort(b);
        Arrays.sort(a,Collections.reverseOrder());
        long ans=0;
        for (int i=0;i<n;i++){
            ans+=((a[i]%998244353)*b[i])%998244353;
            ans%=998244353;
        }
        out.println(ans);
    }
}
