package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class CNewsDistribution {
    static class Node{
        ArrayList<Integer> edges;
        int val;
        int it;
    }

    static Node[] graph;
    static int kadeh=0;
    static boolean[] visited;
    static void dfs(int a, int t){
        visited[a]=true;
        kadeh++;
        graph[a].it=t;
        for (int i: graph[a].edges){
            if (!visited[i]){
                dfs(i,t);
            }
        }
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph=new Node[n];
        for (int i=0;i<n;i++){
            graph[i]=new Node();
            graph[i].edges=new ArrayList<>();
        }
        int k,x,y;
        for (int i=0;i<m;i++){
            k=sc.nextInt();
            if (k>0){
                x=sc.nextInt()-1;
                for (int j=1;j<k;j++){
                    y=sc.nextInt()-1;
                    graph[x].edges.add(y);
                    graph[y].edges.add(x);
                    x=y;
                }
            }
        }

        visited=new boolean[n];
        ArrayList<Integer> it=new ArrayList<>();
        int o=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                kadeh=0;
                dfs(i,o);
                o++;
                it.add(kadeh);
            }
        }

        for (int i=0;i<n;i++) {
            out.print(it.get(graph[i].it)+" ");
        }
    }
}
