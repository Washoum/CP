package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class CBanking {
    static class Pair{
        int x;
        int y;
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] tab=new int[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        Integer[] l=new Integer[m];
        for (int i=0;i<m;i++){
            l[i]=sc.nextInt();
        }
        Arrays.sort(l);
        ArrayList<Pair> arr=new ArrayList<>();
        Pair p=new Pair();
        p.x=l[0];
        p.y=1;
        arr.add(p);
        int a;
        for (int i=1;i<m;i++){
            a=l[i];
            if (arr.get(arr.size()-1).x==a){
                arr.get(arr.size()-1).y++;
            }
            else{
                p=new Pair();
                p.x=a;
                p.y=1;
                arr.add(p);
            }
        }
        long[] freq=new long[1000010];
        for (int i=0;i<arr.size();i++){
            for (int j=arr.get(i).x;j<1000010;j+=arr.get(i).x){
                freq[j]+=arr.get(i).y;
            }
        }

        long ans=0;
        for (int i=0;i<n;i++){
            ans+=freq[tab[i]];
        }
        out.println(ans);
    }
}
