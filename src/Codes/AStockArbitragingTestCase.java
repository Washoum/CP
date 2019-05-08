package Codes;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.*;

public class AStockArbitragingTestCase {
    @TestCase
    public Collection<Test> createTests() {

        ArrayList<Test> tests=new ArrayList<>();
        Random rand=new Random(48946846548L+System.currentTimeMillis());
        for (int u=0;u<1000;u++) {
            StringBuilder t = new StringBuilder();
            int n = 30;
            int m = 30;
            int r= 1+rand.nextInt(1000);
            t.append(n).append(" ").append(m).append(" ").append(r).append("\n");
            int[] tab = new int[n];
            for (int i=0;i<n;i++){
                tab[i]=1+rand.nextInt(1000);
                t.append(tab[i]).append(" ");
            }
            t.append("\n");

            int[] tab2 = new int[m];
            for (int i=0;i<m;i++){
                tab2[i]=1+rand.nextInt(1000);
                t.append(tab2[i]).append(" ");
            }
            tests.add(new Test(t.toString(),stupidsolve(n,tab,m,tab2,r)));
        }
        return tests;
    }

    private String stupidsolve(int n, int[] tab, int m, int[] tab2, int r) {
        Arrays.sort(tab);
        Arrays.sort(tab2);
        int nb=r/tab[0];
        int buy=nb*tab[0];
        int sell=nb*tab2[m-1];
        return String.valueOf(Math.max(r,sell-buy+r));
    }
}
