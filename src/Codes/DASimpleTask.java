package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class DASimpleTask {
    static class Node{
        ArrayList<Integer> edges;
    }
    static boolean rjaa;
    static Node[] graph;
    static boolean[] visited;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph=new Node[n];
        for (int i=0;i<n;i++){
            graph[i]=new Node();
            graph[i].edges=new ArrayList<>();
        }
        int x,y;
        for (int i=0;i<m;i++){
            x=sc.nextInt()-1;
            y=sc.nextInt()-1;
            graph[x].edges.add(y);
            graph[y].edges.add(x);
        }
        int ans=0;
        visited=new boolean[n];
        for (int i=1;i<(1<<n);i++){
            for (int j=0;j<n;j++){
                if ((i & (1<<j))>0){
                    rjaa=false;
                    Arrays.fill(visited,false);
                    dfs(j,j,i,true);
                    for (int k=0;k<n;k++){
                        if ((i & (1<<k))>0 && !visited[k]){
                            rjaa=false;
                            break;
                        }
                    }
                    if (rjaa){
                        ans++;
                    }
                    break;
                }
            }
        }
        out.println(ans);
    }

    private boolean dfs(int a, int b, int mask, boolean first) {
        visited[a]=true;
        if (!first && a==b){
            rjaa=true;
            return true;
        }
        boolean t;
        for (int i : graph[a].edges){
            if (!visited[i]) {
                if ((mask & (1 << i)) > 1) {
                   t= dfs(i, b, mask,false);
                   if (t) {
                       return true;
                   }
                }
            }
            else{
                if (b==i){
                    rjaa=true;
                    return true;
                }
            }
        }
        return false;
    }
}
