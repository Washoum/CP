package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BAllTheVowelsPlease {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int k=sc.nextInt();
        if (k<25){
            out.println(-1);
            return;
        }
        char[] voy={'a','e','u','i','o'};
        boolean found=false;
        int i;
        for (i=5;i<10000;i++){
            if (k%i==0 && k/i>=5){
                found=true;
                break;
            }
        }
        if (!found){
            out.println(-1);
            return;
        }
        int deb=0;
        char[][] grid=new char[i][k/i];
        for (int j=0;j<i;j++){
            for (int l=0;l<k/i;l++){
                grid[j][l]=voy[(deb+l)%5];
            }
            deb++;
        }
        for (int j=0;j<i;j++) {
            for (int l = 0; l < k / i; l++) {
                out.print(grid[j][l]);
            }
        }
    }
}
