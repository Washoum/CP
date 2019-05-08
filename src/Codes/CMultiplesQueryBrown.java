package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class CMultiplesQueryBrown {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] tab=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
            map.putIfAbsent(tab[i], i);
        }
        Integer[] query=new Integer[q];
        int[] ans=new int[n];
        for (int i=0;i<q;i++){
            query[i]=sc.nextInt();
        }
        int[] comb=new int[10001];
        HashMap<Integer,Integer> done=new HashMap<>();
        int max=0;
        boolean[] in=new boolean[10001];
        for(int i=0;i<n;i++){
            if (done.get(tab[i])!=null){
                ans[i]=ans[i-1];
                continue;
            }
            in[tab[i]]=true;
            done.put(tab[i],1);
            for (int j=1;j*j<=tab[i];j++){
                if (tab[i]%j==0){
                    comb[j]++;
                    if (in[j]){
                        max=Math.max(max,comb[j]);
                    }
                    if (tab[i]/j != j){
                        comb[tab[i]/j]++;
                        if (in[tab[i]/j]){
                            max=Math.max(max,comb[tab[i]/j]);
                        }
                    }
                }
            }
            ans[i]=max;
        }
        for (int i=0;i<q;i++){
            out.println(ans[query[i]-1]);
        }
    }
}
