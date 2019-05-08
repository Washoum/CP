package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class HCryptingHelloworldRed {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int a=sc.nextInt();
        HashMap<Integer,Integer> done=new HashMap<>();
        for (int i=0;i<26;i++){
            done.put(i,0);
        }

        for (int i=0;i<26;i++){
            if (done.get((a*i)%26)>0){
                out.println("NO");
                return;
            }
            else{
                done.put((a*i)%26,1);
            }
        }
        out.println("YES");
    }
}
