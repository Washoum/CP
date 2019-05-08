package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MPaintingGreen {
    static class Node{
        ArrayList<Integer> edges;
        long[] tab;
    }

    static Node[] graph;
    static boolean[] visited;
    static int[] color;
    static int n,k;
    static void dfs(int a){
        visited[a]=true;
        if (color[a]>0){
            graph[a].tab[color[a]-1]=1;
            graph[a].tab[color[a]%3]=0;
            graph[a].tab[(color[a]+1)%3]=0;
        }
        else{
            graph[a].tab[0]=1;
            graph[a].tab[1]=1;
            graph[a].tab[2]=1;
        }
        for (int i : graph[a].edges){
            if (!visited[i]){
                dfs(i);

                graph[a].tab[0]*=(graph[i].tab[1]+graph[i].tab[2]);
                graph[a].tab[0]%=mod;
                graph[a].tab[1]*=(graph[i].tab[0]+graph[i].tab[2]);
                graph[a].tab[1]%=mod;
                graph[a].tab[2]*=(graph[i].tab[1]+graph[i].tab[0]);
                graph[a].tab[2]%=mod;
            }
        }
    }

    static final int mod =(int) 1e9 +7;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        graph=new Node[n];
        color=new int[n];
        visited=new boolean[n];
        for (int i=0;i<n;i++){
            graph[i]=new Node();
            graph[i].edges=new ArrayList<>();
            graph[i].tab=new long[3];
        }

        int x,y;
        for (int i=0;i<n-1;i++){
            x=sc.nextInt()-1;
            y=sc.nextInt()-1;
            graph[x].edges.add(y);
            graph[y].edges.add(x);
        }
        for (int i=0;i<k;i++){
            x=sc.nextInt()-1;
            y=sc.nextInt();
            color[x]=y;
        }
        dfs(0);
        out.println((graph[0].tab[0]+graph[0].tab[1]+graph[0].tab[2])%mod);

    }
}
