package Codes;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CPrefixSumPrimesTestCase {
    @TestCase
    public Collection<Test> createTests() {
        ArrayList<Test> tests=new ArrayList<>();
        Random rand=new Random(48946846548L+System.currentTimeMillis());
        for (int u=0;u<1;u++){
            StringBuilder t=new StringBuilder();
            int n=10000;
            t.append(n).append("\n");
            int[] tab=new int[n];
            for (int i=0;i<n;i++){
                tab[i]=1+rand.nextInt(2);
                t.append(tab[i]).append(" ");
            }
            tests.add(new Test(t.toString(),stupidsolve(n,tab)));
        }
        return tests;
    }

    private String stupidsolve(int n, int[] tab) {
        int kadeh1=0;
        int kadeh2=0;
        for (int i=0;i<n;i++){
            if (tab[i]==1){
                kadeh1++;
            }
            else{
                kadeh2++;
            }
        }
        int[] ans=new int[n];
        StringBuilder a=new StringBuilder();
        if (kadeh2>0 && kadeh1>0){
            ans[0]=2;
            ans[1]=1;
            kadeh2--;
            kadeh1--;
            int i;
            for (i=2;kadeh2>0;i++){
                ans[i]=2;
                kadeh2--;
            }
            for (;kadeh1>0;i++){
                ans[i]=1;
                kadeh1--;
            }
        }
        else if (kadeh2>0 && kadeh1==0){
            for (int i=0;i<n;i++){
                ans[i]=2;
            }
        }
        else{
            for (int i=0;i<n;i++){
                ans[i]=1;
            }
        }

        for (int i=0;i<n;i++){
            a.append(ans[i]).append(" ");
        }
        return a.toString();
    }
}
