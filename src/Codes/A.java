package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class A {
    static class Node{
        ArrayList<Pair> edges;
    }
    static class Pair{
        int x;
        int y;
        Pair(int a,int b){
            x=a;
            y=b;
        }
    }
    static ArrayList<Pair> euler;
    static int[][] height;
    static int[][] first;


    void dfs2(int x,int y, int h) {
        visited[x][y] = true;
        height[x][y] = h;
        first[x][y] = euler.size();
        euler.add(new Pair(x,y));
        for (Pair p : graph[x][y].edges) {
            if (!visited[p.x][p.y]) {
                dfs2(p.x,p.y,h+1);
                euler.add(new Pair(x,y));
            }
        }
    }

    static Pair[] segtree;

    static void build(int node, int b, int e) {
        if (b == e) {
            segtree[node] = euler.get(b);
        } else {
            int mid = (b + e) / 2;
            build(node << 1, b, mid);
            build(node << 1 | 1, mid + 1, e);
            Pair l = segtree[node << 1], r = segtree[node << 1 | 1];
            segtree[node] = (height[l.x][l.y] < height[r.x][r.y]) ? l : r;
        }
    }

    static Pair query(int node, int b, int e, int L, int R) {
        if (b > R || e < L)
            return null;
        if (b >= L && e <= R)
            return segtree[node];
        int mid = (b + e) >> 1;

        Pair left = query(node << 1, b, mid, L, R);
        Pair right = query(node << 1 | 1, mid + 1, e, L, R);
        if (left == null) return right;
        if (right == null) return left;
        return height[left.x][left.y] < height[right.x][right.y] ? left : right;
    }

    static Pair lca(Pair u, Pair v) {
        int left = first[u.x][u.y], right = first[v.x][v.y];
        if (left > right){
            int tmp=left;
            left=right;
            right=tmp;
        }
        return query(1, 0, euler.size() - 1, left, right);
    }

    static void dfs(int x, int y, long depth){
        visited[x][y]=true;
        dist[x][y]=depth;
        for (Pair p : graph[x][y].edges){
            if(!visited[p.x][p.y]){
                dfs(p.x,p.y, depth+1);
            }
        }
    }

    static Node[][] graph;
    static boolean[][] visited;
    static int h,w;
    static long[][] dist;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        h=sc.nextInt();
        w=sc.nextInt();
        char[][] in=new char[h+1][2*w+1];

        for (int i=0;i<h+1;i++){
            in[i]=sc.nextLine().toCharArray();
        }
        graph=new Node[h+1][w+1];
        dist=new long[h+1][w+1];
        visited=new boolean[h][w];
        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                graph[i][j]=new Node();
                graph[i][j].edges=new ArrayList<>();
            }
        }
        try {
            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < 2 * w + 1; j += 2) {
                    if (in[i - 1][j] != '_') {
                        graph[i - 1][(j - 1) / 2].edges.add(new Pair(i - 2, (j - 1) / 2));
                    }
                    if (in[i][j] != '_') {
                        graph[i - 1][(j - 1) / 2].edges.add(new Pair(i, (j - 1) / 2));
                    }
                    if (in[i][j - 1] != '|') {
                        graph[i - 1][(j - 1) / 2].edges.add(new Pair(i - 1, (j - 1) / 2 - 1));
                    }
                    if (in[i][j + 1] != '|') {
                        graph[i - 1][(j - 1) / 2].edges.add(new Pair(i - 1, (j - 1) / 2 + 1));
                    }
                }
            }

        height=new int[h+1][w+1];
        first=new int[h+1][w+1];
        euler=new ArrayList<>();
        int m=sc.nextInt();
        int[] t1=new int[m];
        int[] t2=new int[m];
        for (int i=0;i<m;i++){
            t1[i]=sc.nextInt()-1;
            t2[i]=sc.nextInt()-1;
        }
        dfs2(t1[0],t2[0],0);
        for (int i=0;i<h;i++){
            Arrays.fill(visited[i],false);
        }
        dfs(t1[0],t2[0],0);
        int taille=euler.size();
        segtree=new Pair[4*taille];
        build(1,0,taille-1);
        long ans=0;
        if (m>1) {
            ans = dist[t1[1]][t2[1]];
        }
        Pair p;
        for (int i=2;i<m;i++){
            p=lca(new Pair(t1[i-1],t2[i-1]), new Pair(t1[i],t2[i]));
            ans+=dist[t1[i-1]][t2[i-1]]+dist[t1[i]][t2[i]]-2*dist[p.x][p.y];
        }
        out.println(ans);
        }
        catch(Exception e){out.println(-1);}
    }
}
