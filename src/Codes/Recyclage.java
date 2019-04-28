package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class Recyclage {
    static int a,b;
    static int f(int act){
        StringBuilder s=new StringBuilder(String.valueOf(act));
        int toret=0;
        int j=1;
        int b;
        long tot;
        long length=1;
        String h=String.valueOf(act);
        for (int i=0;i<h.length();i++){
            length*=10;
        }
        for (int i=0;i<s.length();i++){
            j*=10;
            b=act%j;
            tot=b*(length/j);
            tot+=act/j;
            if (tot<act && tot >=a){
                toret++;
            }
        }
        return toret;
    }

    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            a=sc.nextInt();
            b=sc.nextInt();

            long ans=0;
            for (int i=a;i<=b;i++){
                ans+=f(i);
            }
            out.println(ans);
        }
    }
}
