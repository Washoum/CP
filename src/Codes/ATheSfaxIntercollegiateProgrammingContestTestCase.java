package Codes;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.*;

public class ATheSfaxIntercollegiateProgrammingContestTestCase {
    @TestCase
    public Collection<Test> createTests() {
        ArrayList<Test> tests=new ArrayList<>();

        Random rand=new Random(489485615498L);

        for (int test=1;test<=1;test++){
            StringBuilder s=new StringBuilder();
            //s.append("1\n");
            int n=100000;
            int q=100000;
            s.append(n).append(" ").append(q).append("\n");
            int[] tab=new int[n];
            for (int i=0;i<n;i++){
                tab[i]=1+rand.nextInt(1000000000);
                s.append(tab[i]).append(" ");
            }
            s.append("\n");
            int[] l=new int[q];
            int[] r=new int[q];
            for (int i=0;i<q;i++){
                l[i]=1+rand.nextInt(n);
                r[i]=1+rand.nextInt(n);
                if (l[i]>r[i]){
                    int tmp=l[i];
                    l[i]=r[i];
                    r[i]=tmp;
                }
                s.append(l[i]).append(" ").append(r[i]).append("\n");
            }
            tests.add(new Test(s.toString()/*,stupidsolve(n,q,tab,l,r)*/));
        }

        return tests;

    }
    static int pow(long x, long y, int p)
    {
        long res = 1;
        x = x % p;

        while (y > 0)
        {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return (int)res;
    }
    private String stupidsolve(int n, int q, int[] tab, int[] l, int[] r) {
        StringBuilder ans=new StringBuilder();
        int mod=(int)1e9+7;
        long[] fact=new long[1000005];
        fact[0]=1;
        for (int i=1;i<100005;i++){
            fact[i]=(fact[i-1]*i)%mod;
        }
        for (int i=0;i<q;i++){
            HashMap<Integer,Integer> occ=new HashMap<>();
            for (int j=l[i]-1;j<=r[i]-1;j++){
                occ.putIfAbsent(tab[j],0);
                occ.put(tab[j],occ.get(tab[j])+1);
            }
            Iterator<Map.Entry<Integer,Integer>> it=occ.entrySet().iterator();
            Map.Entry<Integer,Integer> t;
            long sur=1;
            while(it.hasNext()){
                t=it.next();
                sur*=fact[t.getValue()];
                sur%=mod;
            }
            long toapp=(fact[r[i]-l[i]+1]*pow(sur,mod-2,mod))%mod;
            ans.append(toapp).append("\n");
        }
        return ans.toString();
    }
}
