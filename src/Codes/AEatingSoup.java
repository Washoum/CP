package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class AEatingSoup {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        if (n==m){
            out.println(0);
            return;
        }
        if (m==0){
            out.println(1);
            return;
        }
        boolean[] tab=new boolean[n];
        Arrays.fill(tab, true);
        for (int i=0;i<n && m>0;i+=2){
            tab[i]=false;
            m--;
        }
        for (int i=1;i<n && m>0;i+=2){
            tab[i]=false;
            m--;
        }
        int ans=0;
        for (int i=0;i<n-1;i++){
            if (!tab[i] && tab[i+1]){
                ans++;
            }
        }
        out.println(ans);
    }
}
