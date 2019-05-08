package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class CMatchPoints {
    static Integer[] tab;
    private static int n,z;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        n=sc.nextInt();
        z=sc.nextInt();
        tab=new Integer[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        Arrays.sort(tab);
        boolean[] done=new boolean[n];
        int i=1;
        int j=0;
        int ans=0;
        while (i<n){
            if (tab[i]-tab[j]>=z){
                ans++;
                done[i]=true;
                done[j]=true;
            }
            else{
                i++;
            }
            while (i<n && done[i]) i++;
            while (j<n && done[j]) j++;
        }
        out.println(ans);
    }
}
