package Codes;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CHasanAndHisLazyStudentsTestCase {
    @TestCase
    public Collection<Test> createTests() {
        ArrayList<Test> tests=new ArrayList<>();
        Random rand=new Random(564865648653L+System.currentTimeMillis());

        for (int i=0;i<0;i++){
            StringBuilder t=new StringBuilder();
            t.append("1\n");
            int n=100000;
            int x=1+rand.nextInt((int)1e9);
            t.append(n).append(" ").append(x).append("\n");
            int[] tab=new int[n];
            for (int j=0;j<n;j++){
                tab[j]=rand.nextInt((int)1e9)+1;
                t.append(tab[j]).append(" ");
            }

            tests.add(new Test(t.toString() /*,stupidsolve(n,x,tab)*/));
        }
        return tests;
    }

    private String stupidsolve(int n, int x, int[] tab) {
        long ans=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                long sum=0;
                for (int k=j;k<=i;k++){
                    sum+=tab[k];
                }
                if (sum<=x){
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
