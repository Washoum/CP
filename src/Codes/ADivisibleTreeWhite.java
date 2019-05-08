package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ADivisibleTreeWhite {

    public static ArrayList<Integer> sieve(int n)
    {
        boolean[] prime = new boolean[n+1];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n+1;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++) {
            if(prime[p]) {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        prime[1]=false;
        prime[0]=false;
        for (int i=0;i<n+1;i++){
            if (prime[i]){
                res.add(i);
            }
        }
        return res;
    }


    public class Node{
        ArrayList<Integer> edges;
        int value;
    }

    static boolean[] visited;
    static Node[] graph;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        graph=new Node[n];
        visited=new boolean[n];
        for (int i=0;i<n;i++) {
            graph[i] = new Node();
            graph[i].edges = new ArrayList<>();
            graph[i].value=sc.nextInt();
        }
        int x;
        for (int i=1;i<n;i++){
            x=sc.nextInt()-1;
            graph[x].edges.add(i);
        }
        ArrayList<Integer> primes=sieve(20001);
        int biggest=0;
        int prime=0;
        for (int i=0;i<primes.size();i++){
            Arrays.fill(visited, false);
            for( int j=0;j<n;j++){
                if (!visited[j] && graph[j].value%primes.get(i)==0){
                    kadeh=0;
                    dfs(j,primes.get(i));
                    if (kadeh>biggest){
                        biggest=kadeh;
                        prime=primes.get(i);
                    }
                }
            }
        }

        out.println(prime+" "+biggest);
    }
    static int kadeh;
    private void dfs(int a, Integer p) {
            visited[a]=true;
            kadeh++;
            for (int i : graph[a].edges){
                if (!visited[i] && graph[i].value%p==0){
                    dfs(i,p);
                }
            }
    }
}
