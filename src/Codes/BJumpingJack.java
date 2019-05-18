package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BJumpingJack {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        long i=1;
        while ((i*(i+1))/2 <Math.abs(n)){
            i++;
        }
        if ((i*(i+1))/2 ==Math.abs(n)){
            out.println(i);
            return;
        }
        long sur=(i*(i+1))/2-Math.abs(n);
        long j=1;
        while ((j*(j+1))/2 < sur){
            j++;
        }
        if ((j*(j+1))/2 == sur){
            out.println(i+j);
            return;
        }
        out.println(i+j);
    }
}
