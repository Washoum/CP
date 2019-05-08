package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BResale {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] value=new int[n];
        for (int i=0;i<n;i++){
            value[i]=sc.nextInt();
        }
        int[] cost=new int[n];
        for (int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }

        int[][] dp=new int[n+1][51*n];
        boolean[][] go=new boolean[n+1][51*n];

        go[0][0]=true;

        for (int i=0;i<n;i++){
            for (int j=0;j< 51*n;j++){
                if (go[i][j]){
                    if (!go[i+1][j]){
                        dp[i+1][j]=dp[i][j];
                    }
                    else{
                        if (j-dp[i+1][j]<j-dp[i][j]){
                            dp[i+1][j]=dp[i][j];
                        }
                    }
                    go[i+1][j]=true;

                    if (!go[i+1][j+value[i]]){
                        dp[i+1][j+value[i]]=dp[i][j]+cost[i];
                    }
                    else{
                        if (j+value[i]-dp[i+1][j+value[i]]<j+value[i]-dp[i][j]-cost[i]){
                            dp[i+1][j+value[i]]=dp[i][j]+cost[i];
                        }
                    }
                    go[i+1][j+value[i]]=true;
                }
            }
        }

        int max=0;
        for (int i=0;i<51*n;i++){
            if (go[n][i])
                max=Math.max(max,i-dp[n][i]);
        }
        out.println(max);
    }
}
