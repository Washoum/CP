package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class newExactlyTwice {

    public static class Query{
        int l;
        int r;
        int idx;
        Query(int a, int b, int c){
            l=a;
            r=b;
            idx=c;
        }
    }
    static Query[] queries;
    static int n,q;
    static long currentans;
    static int[] tab;
    static int[] freq;
    static final int mod=(int)1e9+7;
    static long[] fact;
    static long[] inv, ans;

//    private static void remove(int i) {
//        currentKadeh*= freq[i];
//        currentKadeh%=mod;
//        freq[i]--;
//
//    }
//
//    private static void add(int i) {
//        freq[i]++;
//        currentKadeh*=inv[freq[i]];
//        currentKadeh%=mod;
//    }

    private static void remove(int i) {
        freq[i]--;
        if (freq[i]==0){
            currentans--;
        }
    }

    private static void add(int i) {
        freq[i]++;
        if (freq[i]==1){
            currentans++;
        }
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


    public void solve(int testNumber, inputClass sc, PrintWriter out) {
//        fact=new long[100005];
//        inv=new long[100005];
//        fact[0]=1;
//        inv[0]=1;
//        for (int i=1;i<100005;i++){
//            fact[i]=(fact[i-1]*i)%mod;
//            inv[i]=(pow(i,mod-2,mod))%mod;
//        }
//        int t = sc.nextInt();
//        while (t > 0) {
//            t--;
            n = sc.nextInt();
            //q = sc.nextInt();
            tab = new int[n];
            currentans = 0;
            for (int i = 0; i < n; i++) {
                tab[i] = sc.nextInt();
            }
            int q=sc.nextInt();
            queries = new Query[q];
            int x, y;
            for (int i = 0; i < q; i++) {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                queries[i] = new Query(x, y, i);
            }
            int block = (int) Math.sqrt(n);

            Arrays.parallelSort(queries, new Comparator<Query>() {
                @Override
                public int compare(Query a, Query b) {
                    if (a.l / block != b.l / block) {
                        return Integer.compare(a.l / block, b.l / block);
                    }
                    if (a.l / block % 2 == 1) {
                        return Integer.compare(a.r, b.r);
                    } else {
                        return Integer.compare(b.r, a.r);
                    }
                }
            });

            ans = new long[q];
            freq = new int[1000010];
            int curL = 0;
            int curR = 0;
            int l, r;
            for (int i = 0; i < q; i++) {
                l = queries[i].l;
                r = queries[i].r;
                while (curL > l) {
                    curL--;
                    add(tab[curL]);
                }
                while (curR <= r) {
                    add(tab[curR]);
                    curR++;
                }
                while (curL < l) {
                    remove(tab[curL]);
                    curL++;
                }
                while (curR > r + 1) {
                    curR--;
                    remove(tab[curR]);
                }
                ans[queries[i].idx] = currentans;
            }
            for (int i = 0; i < q; i++) {
                out.println(ans[i]);
            }

        //}
}

    }
