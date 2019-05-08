package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class D01Tree {
    static class Node{
        ArrayList<Integer> edges;
        int comp;
    }

    static Node[] graph0, graph1;
    static boolean[] visited0,visited1;
    static ArrayList<Integer> comp0,comp1;
    static int size;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int x,y,w;
        graph0=new Node[n];
        graph1=new Node[n];
        visited0=new boolean[n];
        visited1=new boolean[n];
        comp0=new ArrayList<>();
        comp1=new ArrayList<>();
        for (int i=0;i<n;i++){
            graph0[i]=new Node();
            graph0[i].edges=new ArrayList<>();
            graph1[i]=new Node();
            graph1[i].edges=new ArrayList<>();
        }
        for (int i=0;i<n-1;i++){
            x=sc.nextInt()-1;
            y=sc.nextInt()-1;
            w=sc.nextInt();
            if (w==1){
                graph1[x].edges.add(y);
                graph1[y].edges.add(x);
            }
            else if (w==0){
                graph0[x].edges.add(y);
                graph0[y].edges.add(x);
            }
        }

        for (int i=0;i<n;i++){
            if (!visited0[i]){
                size=0;
                dfs0(i,comp0.size());
                comp0.add(size);
            }
        }
        for (int i=0;i<n;i++){
            if (!visited1[i]){
                size=0;
                dfs1(i,comp1.size());
                comp1.add(size);
            }
        }

        long ans=0;
        for (int i=0;i<comp0.size();i++){
            ans+=(long)comp0.get(i)*(long)(comp0.get(i)-1);
        }
        for (int i=0;i<comp1.size();i++){
            ans+=(long)comp1.get(i)*(long)(comp1.get(i)-1);
        }

        for (int i=0;i<n;i++){
            if (comp0.get(graph0[i].comp)>1 && comp1.get(graph1[i].comp)>1){
                ans+=(long)(comp0.get(graph0[i].comp)-1)*(long)(comp1.get(graph1[i].comp)-1);
            }
        }
        out.println(ans);
    }

    private void dfs0(int a, int c) {
        visited0[a]=true;
        graph0[a].comp=c;
        size++;
        for (int i: graph0[a].edges){
            if (!visited0[i])
                dfs0(i,c);
        }
    }
    private void dfs1(int a, int c) {
        visited1[a]=true;
        graph1[a].comp=c;
        size++;
        for (int i: graph1[a].edges){
            if (!visited1[i])
                dfs1(i,c);
        }
    }
}
