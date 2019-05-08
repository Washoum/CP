package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BTilingChallenge {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        char[][] grid=new char[n][n];
        for (int i=0;i<n;i++){
            grid[i]=sc.nextLine().toCharArray();
        }
        boolean[][] done=new boolean[n][n];
        for (int i=0;i<n;i++){
            for( int j=0;j<n;j++){
                if (grid[i][j]=='#'){
                    done[i][j]=true;
                }
            }
        }

        for( int i=1;i<n-1;i++){
            for (int j=1;j<n-1;j++){
                if (!done[i][j] && !done[i-1][j] && !done[i+1][j] && !done[i][j-1] && !done[i][j+1]){
                    done[i][j]=true;
                    done[i+1][j]=true;
                    done[i-1][j]=true;
                    done[i][j+1]=true;
                    done[i][j-1]=true;
                }
            }
        }

        for (int i=0;i<n;i++){
            for( int j=0;j<n;j++){
                if (!done[i][j]){
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");


    }
}
