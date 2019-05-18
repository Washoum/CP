package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class CThePartyAndSweets {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        Integer[] b=new Integer[n];
        Integer[] g=new Integer[m];
        long sum=0;
        for (int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        for (int i=0;i<m;i++){
            g[i]=sc.nextInt();
            sum+=g[i];
        }
        Arrays.sort(b);
        Arrays.sort(g);
        if (b[n-1]>g[0]){
            out.println(-1);
            return;
        }
        if (b[n-1].intValue()==g[0]){
            long ans=sum;
            for (int i=0;i<n-1;i++){
                ans+=((long)b[i]*m);
            }
            out.println(ans);
        }
        else{
            long ans=sum-g[0]+b[n-1];
            ans+=g[0]+((long)b[n-2]*(m-1));
            for (int i=0;i<n-2;i++){
                ans+=((long)b[i]*m);
            }
            out.println(ans);
        }
    }
}
