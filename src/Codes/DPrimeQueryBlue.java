package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DPrimeQueryBlue {
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

    static int build(int node, int l, int r){
        if (l==r){
            segtree[node]=map.get(tab[l])==null? 0 : 1;
            return segtree[node];
        }
        int mid=(l+r)/2;
        segtree[node]=build(node*2+1,l,mid)+build(node*2+2,mid+1,r);
        return segtree[node];
    }

    static int query(int node,int ql, int qr, int actl, int actr){
        if (ql<=actl && qr >=actr){
            return segtree[node];
        }
        if (ql > actr ||  qr < actl){
            return -1;
        }
        int mid =(actl+actr)/2;
        int a=query(node*2+1,ql,qr,actl,mid);
        int b=query(node*2+2,ql,qr,mid+1,actr);;
        int ret=0;
        if (a>=0)
            ret+=a;
        if (b>=0){
            ret+=b;
        }
        return ret;
    }

    static void update(int node, int idx, int val, int l, int r){
        if (idx< l|| idx>r){
            return;
        }
        if (l==r){
            tab[idx]+=val;
            segtree[node]=(map.get(tab[idx])==null)? 0:1;
            return;
        }
        int mid=(l+r)/2;
        if (idx>=l && idx <=mid){
            update(node*2+1,idx,val,l,mid);
        }
        else{
            update(node*2+2,idx,val,mid+1,r);
        }
        segtree[node]=segtree[node*2+1]+segtree[node*2+2];
    }

    private static int[] segtree;
    static int[] tab;
    static HashMap<Integer,Boolean> map;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        ArrayList<Integer> primes=sieve(2000000);
        map=new HashMap<>();
        for (Integer prime : primes) {
            map.put(prime, true);
        }
        int n=sc.nextInt();
        int q=sc.nextInt();
        tab=new int[n];
        segtree=new int[4*n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        int t,x,y;
        build(0,0,n-1);
        for (int i=0;i<q;i++){
            t=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
            if (t==1){
                out.println(query(0,x-1,y-1,0,n-1));
            }
            else{
                update(0,x-1,y,0,n-1);
            }
        }
    }
}
