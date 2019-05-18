package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class BPolycarpTraining {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        Integer[] tab=new Integer[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        Arrays.sort(tab);
        int a=0;
        for (int i=0;i<n;i++){
            if (tab[i]>=a+1){
                a++;
            }
        }
        out.println(a);
    }
}
