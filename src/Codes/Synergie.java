package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class Synergie {
    static class Subset
    {
        int parent;
        int size;
    }

    static int find( int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(int x , int y )
    {
        int xroot = find(x);
        int yroot = find(y);

        if (subsets[xroot].size < subsets[yroot].size) {
            subsets[xroot].parent = yroot;
            subsets[yroot].size+=subsets[xroot].size;
        }
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].size += subsets[yroot].size;
        }
    }

    static Subset[] subsets;

    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            int n = sc.nextInt();
            int m=sc.nextInt();
            subsets = new Subset[n];
            for (int i = 0; i < n; i++) {
                subsets[i] = new Subset();
                subsets[i].parent = i;
                subsets[i].size = 1;
            }
            long ans=0;
            int x,y;
            for (int i=0;i<m;i++){
                x=sc.nextInt()-1;
                y=sc.nextInt()-1;
                ans+=(subsets[find(x)].size+subsets[find(y)].size);
                union(x,y);
            }
            out.println(ans);

        }

    }
}
