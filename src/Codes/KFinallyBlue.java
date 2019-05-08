package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class KFinallyBlue {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        loop :while (t>0){
            t--;
            int n=sc.nextInt();

            double a;
            for(long l=1;((l*l)+l)/2<=n;l++){
                a=(double)(n-((l*l)+l)/2)/(l+1);
                if (Math.round(a)!=0 && Math.abs(a-Math.round(a))<0.000001){
                    out.println("YES");
                    out.println((int)Math.round(a)+" "+((int)Math.round(a)+l));
                    continue loop;

                }
            }
            out.println("NO");
        }
    }
}
