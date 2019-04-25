package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.*;

public class BLetMeSleep {
    static class Node{
        HashMap<Integer,Boolean> edges;
    }

    private static int timer;
    private static int[] tin,low;
    private static void dfs3(int a, int p){
        visited[a]=true;
        tin[a]=timer++;
        low[a]=timer++;
        Iterator<Map.Entry<Integer,Boolean>> it=graph[a].edges.entrySet().iterator();
        Map.Entry<Integer,Boolean> t;
        while (it.hasNext()){
            t=it.next();
            int i=t.getKey();
            if (i==p) continue;
            if (visited[i]){
                low[a]=Math.min(low[a],tin[i]);
            } else{
                dfs3(i,a);
                low[a]=Math.min(low[a], low[i]);
                if (low[i] > tin[a]){
                    bridges.add(new Edge(i,a));
                }
            }
        }
    }
    private static ArrayList<Edge> bridges;
    static class Edge{
        Edge(int a, int b){
            u=a;
            v=b;
        }
        int u,v;
    }
    static class Tree{
        ArrayList<Integer> edges;
    }


    private static Tree[] tree;
    private static Node[] graph;
    private static Node[] graph2;
    private static boolean[] visited;
    private static int[] visited2;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            bridges=new ArrayList<>();
            int n=sc.nextInt();
            int m=sc.nextInt();
            graph=new Node[n];
            for (int i=0;i<n;i++){
                graph[i]=new Node();
                graph[i].edges=new HashMap<>();
            }
            graph2=new Node[n];
            for (int i=0;i<n;i++){
                graph2[i]=new Node();
                graph2[i].edges=new HashMap<>();
            }
            visited2=new int[n];
            visited=new boolean[n];
            int x,y;
            for (int i=0;i<m;i++){
                x=sc.nextInt()-1;
                y=sc.nextInt()-1;
                graph[x].edges.put(y,true);
                graph[y].edges.put(x,true);
                graph2[x].edges.put(y,true);
                graph2[y].edges.put(x, true);
            }
            timer=0;
            tin=new int[n];
            low=new int[n];
            Arrays.fill(tin,-1);
            Arrays.fill(low,-1);
            dfs3(0,-1);
            for (Edge bridge : bridges) {
                graph2[bridge.u].edges.remove(bridge.v);
                graph2[bridge.v].edges.remove(bridge.u);
            }
            int nb=0;
            for (int i=0;i<n;i++){
                if (visited2[i]==0){
                    nb++;
                    dfs(i,nb);
                }
            }

            tree=new Tree[nb];
            for (int i=0;i<nb;i++){
                tree[i]=new Tree();
                tree[i].edges=new ArrayList<>();
            }

            for (Edge bridge : bridges) {
                tree[visited2[bridge.u] - 1].edges.add(visited2[bridge.v] - 1);
                tree[visited2[bridge.v] - 1].edges.add(visited2[bridge.u] - 1);
            }
            int i;
            for(i=0;i<nb;i++){
                if (tree[i].edges.size()==1){
                    break;
                }
            }
            if (i==nb){
                out.println("0");

            }else {
                int[] tmp = abeed(i, -1);
                int[] ans = abeed(tmp[1], -1);
                out.println(nb - 1 - ans[0]);
            }


        }
    }
    private int[] abeed(int a, int par){
        int[] max=new int[2];
        max[1]=a;
        int[] tmp;
        for (int i: tree[a].edges){
            if (i==par)
                continue;
            tmp=abeed(i,a);
            if (max[0]<1+tmp[0]){
                max[0]=1+tmp[0];
                max[1]=tmp[1];
            }
        }
        return max;
    }
    private void dfs(int a, int nb) {
        visited2[a]=nb;
        Iterator<Map.Entry<Integer,Boolean>> it=graph2[a].edges.entrySet().iterator();
        Map.Entry<Integer,Boolean> t;
        while (it.hasNext()) {
            t = it.next();
            int i = t.getKey();
            if (visited2[i]==0)
                dfs(i,nb);
        }
    }
}
