package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class AReachableNumbers {
    static int f(int a){
        a+=1;
        StringBuilder s=new StringBuilder(String.valueOf(a));
        while (s.charAt(s.length()-1)=='0'){
            s.deleteCharAt(s.length()-1);
        }
        return Integer.valueOf(s.toString());
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        HashMap<Integer,Integer> done=new HashMap<>();
        int ans=0;
        int x=n;
        while (done.get(x)==null){
            done.put(x,1);
            ans++;
            x=f(x);
        }
        out.println(ans);
    }
}
