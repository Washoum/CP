package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class GWinnableGameOrange {
    static int n,k;
    static int[] tab;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        n=sc.nextInt();
        k=sc.nextInt();
        tab=new int[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        int l=0;
        int r=n;
        int ans=0;
        while (r-l>=0){
            int mid=(l+r)/2;
            if (check(mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        out.println(ans);

    }

    private boolean check(int mid) {
        long act=0;
        for (int i=0;i<n-mid;i++){
            act+=tab[i];
        }
        if (act<=k){
            return true;
        }
        int i=n-mid;
        int start=0;
        while (i<n){
            act+=tab[i];
            act-=tab[start];
            i++;
            start++;
            if (act<=k){
                return true;
            }
        }
        return false;
    }
}
