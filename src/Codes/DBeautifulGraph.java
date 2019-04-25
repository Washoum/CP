package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DBeautifulGraph {
    static class Node{
        ArrayList<Integer> edges;
        long[] values;
    }

    static class Pair{
        int x,y;
        Pair( int a, int b){
            x=a;
            y=b;
        }
    }
    static long ans;
    static void bfs(int a,int parity){
        LinkedList<Pair> queu=new LinkedList<>();
        queu.addLast(new Pair(a,parity));
        visited[a]=parity;
        int act;
        Pair p;
        while (!queu.isEmpty()){
            p=queu.pollFirst();
            act=p.x;
            for (int i : graph[act].edges){
                if (visited[i]==-1) {
                    visited[i]=(parity + 1) % 2;
                    queu.addLast(new Pair(i, (parity + 1) % 2));
                    if(p.y==1){
                        ans*=2;
                        ans%=998244353;
                    }
                }
                else{
                    if (visited[i]==p.y){
                        ans=0;
                    }
                    else if (p.y==1){
                        ans*=2;
                        ans%=998244353;
                    }
                }
            }
        }
    }
    static Node[] graph;
    static int[] visited;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            graph=new Node[n];
            visited=new int[n];
            ans=1;
            for (int i=0;i<n;i++){
                graph[i]=new Node();
                graph[i].edges=new ArrayList<>();
                graph[i].values=new long[3];
            }
            int x,y;
            for (int i=0;i<m;i++){
                x=sc.nextInt()-1;
                y=sc.nextInt()-1;
                graph[x].edges.add(y);
                graph[y].edges.add(x);
            }
            Arrays.fill(visited,-1);
            bfs(0,0);
            Arrays.fill(visited,-1);
            bfs(0,1);
            out.println(ans);


        }

    }
}
