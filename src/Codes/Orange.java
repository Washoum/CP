package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Orange {
    static long[][] dist;
    static void dijkstra(){
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingLong(o -> o.w));
        Pair tmp=new Pair(0,0,0);
        pq.add(tmp);
        while(!pq.isEmpty()){
            tmp=pq.poll();
            if (tmp.w>dist[tmp.x][tmp.y]){
                continue;
            }
            if (tmp.y==0){
                for (int i=0;i<n;i++){
                    if(dist[0][0]+grid[tmp.x][tmp.y] < dist[i][1]){
                        dist[i][1]=0;
                        Pair tmp2=new Pair(i,1,0);
                        pq.add(tmp2);
                    }
                }
            }
            else{
                if(tmp.x<n-1 && dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y] < dist[tmp.x+1][tmp.y]){
                    dist[tmp.x+1][tmp.y]=dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y];
                    Pair tmp2=new Pair(tmp.x+1,tmp.y,dist[tmp.x+1][tmp.y]);
                    pq.add(tmp2);
                }
                if(tmp.x>0 && dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y] < dist[tmp.x-1][tmp.y]){
                    dist[tmp.x-1][tmp.y]=dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y];
                    Pair tmp2=new Pair(tmp.x-1,tmp.y,dist[tmp.x-1][tmp.y]);
                    pq.add(tmp2);
                }
                if(tmp.y<=n && dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y] < dist[tmp.x][tmp.y+1]){
                    dist[tmp.x][tmp.y+1]=dist[tmp.x][tmp.y]+grid[tmp.x][tmp.y];
                    Pair tmp2=new Pair(tmp.x,tmp.y+1,dist[tmp.x][tmp.y+1]);
                    pq.add(tmp2);
                }
            }
        }
    }

    static class Pair{
        int x;
        int y;
        long w;

        Pair(int a,int c, long b){
            x=a;
            y=c;
            w=b;
        }
    }
    static int n;
    static int[][] grid;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        n=sc.nextInt();
        grid=new int[n][n+2];
        for (int i=0;i<n;i++){
            for (int j=1;j<=n;j++) {
                grid[i][j]=sc.nextInt();
            }
        }

        dist=new long[n][n+2];
        for (int i=0;i<n;i++) {
            Arrays.fill(dist[i], 100000000000000L);
        }
        dist[0][0]=0;

        dijkstra();
        long ans=100000000000000L;
        for (int i=0;i<n;i++){
            ans=Math.min(ans,dist[i][n+1]);
        }
        out.println(ans);
    }
}
