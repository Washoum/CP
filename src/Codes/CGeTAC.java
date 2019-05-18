package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class CGeTAC {
    static class Pair{
        int x,y;
        Pair( int a, int b){
            x=a;
            y=b;
        }
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.nextLine();
        TreeSet<Pair> set = new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.x,b.x);
            }
        });
        int cnt=1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'C') {
                set.add(new Pair(i,cnt));
                cnt++;
            }
        }
        int l, r;
        Pair x,y;
        for (int i = 0; i < q; i++) {
            l = sc.nextInt() - 1;
            r = sc.nextInt() - 1;
            x=set.lower(new Pair(r,0));
            y=set.lower(new Pair(l,0));
            if (x==null){
                out.println(0);
            }
            else if (y==null){
                out.println(x.y);
            }
            else{
                out.println(x.y-y.y);
            }
        }
    }
}
