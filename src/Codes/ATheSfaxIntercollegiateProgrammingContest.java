package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ATheSfaxIntercollegiateProgrammingContest {
    static Query[] queries;
    static int n;
    static int q;
    static int currentans;
    static int[] tab;
    static int[] ans;
    static int blocksize;
    static HashMap<Integer, Integer> map;

    public static class Query {
        int l;
        int r;
        int idx;
        int block;

        Query(int a, int b, int c) {
            l = a;
            r = b;
            idx = c;
            block=l/blocksize;
        }

    }
    private static void remove ( int i){
        map.put(i, map.get(i) - 1);
        if (map.get(i) == 2) {
            currentans++;
        } else if (map.get(i) == 1) {
            currentans--;
        }
    }

    private static void add ( int i){
        map.putIfAbsent(i, 0);
        map.put(i, map.get(i) + 1);
        if (map.get(i) == 2) {
            currentans++;
        } else if (map.get(i) == 3) {
            currentans--;
        }
    }

    public void solve ( int testNumber, inputClass sc, PrintWriter out){
        n = sc.nextInt();
        q = sc.nextInt();
        tab = new int[n];
        currentans = 0;
        for (int i = 0; i < n; i++) {
            tab[i] = sc.nextInt();
        }
        queries = new Query[q];
        int x, y;
        blocksize = (int) Math.sqrt(n);
        for (int i = 0; i < q; i++) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            queries[i] = new Query(x, y, i);
        }

        Arrays.sort(queries,
                new Comparator<Query>() {

                    public int compare(Query a, Query b) {
                        if (a.block != b.block) {
                            return Integer.compare(a.block, b.block);
                        }
                        if (a.block % 2 == 1) {
                            return Integer.compare(a.r, b.r);
                        } else {
                            return Integer.compare(b.r, a.r);
                        }
                    }
                }
        );
        ans = new int[q];
        map = new HashMap<>();
        int curL = 0;
        int curR = 0;

        for (int i = 0; i < q; i++) {
            int l = queries[i].l;
            int r = queries[i].r;

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
    }

}
