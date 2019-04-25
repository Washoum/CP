package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class CHasanAndHisLazyStudents {
    private static final int mod=(int)1e9+7;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;

            int n=sc.nextInt();
            int[] tab=new int[n];
            for (int i=0;i<n;i++){
                tab[i]=sc.nextInt();
            }

            long[][] dp=new long[n][n];
            for (int i=0;i<n;i++){
                dp[0][i]=1;
            }
            long sum;
            int i;
            long ans=n;
            for (i=1;i<n;i++){
                sum=0;
                for (int j=0;j<n;j++){
                    for (int k=0;k<j;k++){
                        if (tab[k]<tab[j]){
                            dp[i][j]+=dp[i-1][k];
                            dp[i][j]%=mod;
                        }
                    }
                    sum+=dp[i][j];
                    sum%=mod;
                }
                if (sum==0){
                    break;
                }
                ans=sum;
                ans%=mod;
            }
            out.println(i+" "+ans);
        }
    }
}
