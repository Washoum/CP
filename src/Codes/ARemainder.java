package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class ARemainder {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s=sc.nextLine();
        int nb=0;
        for (int i=n-1;i>=n-y;i--){
            if (s.charAt(i)=='1'){
                nb++;
            }
        }
        if (s.charAt(n-1-y)=='0'){
            nb++;
        }
        for (int i=n-y-2;i>=n-x;i--){
            if (s.charAt(i)=='1'){
                nb++;
            }
        }
        out.println(nb);
    }
}
