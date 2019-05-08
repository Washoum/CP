package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class DFlippingSigns {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        long sum=0;
        int nb=0;
        int[] tab=new int[n];
        for( int i=0;i<n;i++){
            tab[i]=sc.nextInt();
            sum+=Math.abs(tab[i]);
            if (tab[i]<=0){
                nb++;
            }
        }
        if (nb%2==0){
            out.println(sum);
        }
        else{
            int min=Integer.MAX_VALUE;
            for (int i=0;i<n;i++) {
                min = Math.min(min, Math.abs(tab[i]));
            }
            out.println(sum-2*min);
        }
    }
}
