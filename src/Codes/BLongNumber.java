package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class BLongNumber {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        StringBuilder s=new StringBuilder(sc.nextLine());
        HashMap<Integer,Integer> perm=new HashMap<>();
        for (int i=0;i<9;i++){
            perm.put(i+1,sc.nextInt());
        }
        boolean begin=false;
        for (int i=0;i<n;i++){
            int a=s.charAt(i)-'0';
            if (perm.get(a)>a && !begin){
                begin=true;
                s.setCharAt(i,(char)(perm.get(a)+'0'));
            }
            else if (perm.get(a)>a && begin){
                s.setCharAt(i,(char)(perm.get(a)+'0'));
            }
            else if (perm.get(a)<a && begin){
                break;
            }

        }
        out.println(s);
    }
}
