package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class Bitcoin {
    static HashMap<Long,Long> map;

    static long f(long a){
        if (map.get(a)!=null){
            return map.get(a);
        }
        if (a==0)
            return 0;
        long x=f(a/2)+f(a/3)+f(a/4);
        if (x>a){
            map.put(a,x);
        }
        else
            map.put(a,a);
        return map.get(a);
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            map=new HashMap<>();
            long n=sc.nextLong();
            out.println(f(n));
        }
    }
}
