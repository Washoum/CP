package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class DWeLikeAGC {
    static final int mod=(int) 1e9+7;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        long[][] dp=new long[n+1][4];
        dp[0][0]=1;
        dp[0][1]=1;
        dp[0][2]=1;
        dp[0][3]=1;
        dp[1][0]=3;
        dp[1][1]=3;
        dp[1][2]=3;
        dp[1][3]=3;
        dp[2][0]=16;
        dp[2][1]=14;
        dp[2][2]=15;
        dp[2][3]=16;
        for (int i=3;i<n;i++){
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+dp[i-1][2])%mod;
            dp[i][1]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+(dp[i-1][2]-dp[i-2][0]))%mod;
            dp[i][2]=(dp[i-1][0]+(dp[i-1][1]-dp[i-2][0])+dp[i-1][3]+dp[i-1][2])%mod;
            dp[i][3]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+dp[i-1][2])%mod;
        }
        long ans=0;
        for (int i=0;i<4;i++){
            ans+=dp[n-1][i];
            ans%=mod;
        }
        out.println(ans);

    }
}
