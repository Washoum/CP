package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.*;

public class CGCDOnBlackboard {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] tab=new int[n];
        for ( int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> divs=new HashMap<>();
        for (long j=1; j*j<=tab[0];j++){
            if (tab[0]%j==0){
                divs.putIfAbsent((int)j,1);
                if (tab[0]/j != j){
                    divs.putIfAbsent((int)(tab[0]/j),1);
                }
            }
        }
        for (long j=1; j*j<=tab[1];j++){
            if (tab[1]%j==0){
                divs.putIfAbsent((int)j,1);
                if (tab[1]/j != j){
                    divs.putIfAbsent((int)(tab[1]/j),1);
                }
            }
        }
        ArrayList<Integer> divisors=new ArrayList<>();
        Iterator<Map.Entry<Integer,Integer>> it=divs.entrySet().iterator();
        Map.Entry<Integer,Integer> t;
        while (it.hasNext()){
            t=it.next();
            divisors.add(t.getKey());
        }
        Collections.sort(divisors);
        int[] poss=new int[divisors.size()];
        for (int i=0;i<n;i++){
            for (int j=0;j<divisors.size();j++){
                if (tab[i]%divisors.get(j)==0){
                    poss[j]++;
                }
            }
        }
        int ans=0;
        for (int i=0;i<divisors.size();i++){
            if (poss[i]==n-1 || poss[i]==n){
                ans=i;
            }
        }
        out.println(divisors.get(ans));
    }
}
