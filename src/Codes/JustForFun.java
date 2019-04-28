package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class JustForFun {

    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            int n=sc.nextInt();
            long[][] dp=new long[n+1][n+1];
            dp[0][0]=1;
            for (int i=2;i<=n;i++){
                for (int j=i-1;j>=2;j--){
//                    dp[i]+=dp[j];
                }
            }
        }
    }
}
