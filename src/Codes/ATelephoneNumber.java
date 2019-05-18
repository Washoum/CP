package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class ATelephoneNumber {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t > 0) {
            t--;
            int n=sc.nextInt();
            String s=sc.nextLine();
            if (n<11){
                out.println("NO");
                continue;
            }
            int pos=-1;
            for (int i=0;i<n;i++){
                if (s.charAt(i)=='8'){
                    pos=i;
                    break;
                }
            }
            if (pos==-1){
                out.println("NO");
                continue;
            }
            if (pos<=n-11){
                out.println("YES");
            }
            else
                out.println("NO");

        }
    }
}
