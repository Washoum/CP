package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class AStockArbitraging {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        int r=sc.nextInt();

        int[] a=new int[n];
        int min=10000;
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
            min=Math.min(a[i],min);
        }

        int[] b=new int[m];
        int max=0;
        for (int i=0;i<m;i++){
            b[i]=sc.nextInt();
            max=Math.max(b[i],max);
        }
        if (min>=max){
            out.println(r);
        }
        else{
            int rem=r%min;
            int kadeh=r/min;
            int ans=kadeh*max+rem;
            out.println(ans);
        }
    }
}
