package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BTypewriter {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int h=sc.nextInt();
        if (h==0){
            out.println(1);
            return;
        }
        if (h==1){
            out.println(0);
            return;
        }
        StringBuilder t=new StringBuilder();
        if (h%2==0){
            for (int i=0;i<h/2;i++){
                t.append('8');
            }
        }
        else {
            t.append('4');
            for (int i=0;i<h/2;i++){
                t.append('8');
            }
        }
        out.println(t);
    }
}
