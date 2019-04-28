package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class DClassAttendance {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int r=sc.nextInt();
        int c=sc.nextInt();
        char[][] grid=new char[r][c];
        for (int i=0;i<r;i++){
            Arrays.fill(grid[i],'.');
        }
        if (n>=r+c-1){
            for( int i=0;i<r;i++){
                grid[i][0]='#';
            }
            for( int i=1;i<c;i++){
                grid[0][i]='#';
            }
            int rem=n-r-c+1;
            for (int i=1;i<r && rem>0;i++){
                for ( int j=1;j<c && rem>0;j++){
                    grid[i][j]='#';
                    rem--;
                }
            }
            out.println(Math.min(r,c));
            for (int i=0;i<r;i++){
                for ( int j=0;j<c;j++){
                    out.print(grid[i][j]);
                }
                out.println();
            }
        }
        else{
            grid[0][0]='#';
            n--;
            int max1=1;
            int max2=1;
            for (int i=1;i<Math.max(r,c) && n>0;i++){
                if (i < r) {
                    grid[i][0]='#';
                    n--;
                    max1++;
                }
                if (i<c){
                    if (n>0){
                        grid[0][i]='#';
                        n--;
                        max2++;
                    }
                }
            }
            out.println(Math.min(max1,max2));
            for (int i=0;i<r;i++){
                for ( int j=0;j<c;j++){
                    out.print(grid[i][j]);
                }
                out.println();
            }

        }
    }
}
