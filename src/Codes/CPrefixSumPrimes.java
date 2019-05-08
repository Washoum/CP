package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CPrefixSumPrimes {
    public static ArrayList<Integer> sieve(int n)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++) {
            if(prime[p]) {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        prime[1]=false;
        prime[0]=false;
        for (int i=2;i<n+1;i++){
            if (prime[i]){
                ans.add(i);
            }
        }
        return ans;
    }


    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] tab=new int[n];
        int kadeh1=0;
        int kadeh2=0;
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
            if (tab[i]==1){
                kadeh1++;
            }
            else if (tab[i]==2){
                kadeh2++;
            }
        }
        ArrayList<Integer> primes=sieve(400001);
        int[] ans=new int[n];
        long sum=0;
        int j=0;
        for (int i=0;i<n;i++){
            if (sum+2<=primes.get(j)){
                if (kadeh2>0){
                    if (sum+2==primes.get(j)){
                        j++;
                    }
                    ans[i]=2;
                    kadeh2--;
                    sum+=2;
                }
                else if (kadeh1>1 && i<n-1){
                    if (sum+2==primes.get(j)){
                        j++;
                    }
                    ans[i]=1;
                    ans[i+1]=1;
                    kadeh1-=2;
                    i++;
                    sum+=2;
                }
                else if (kadeh1>0){
                    kadeh1--;
                    ans[i]=1;
                    sum++;
                }
            }
            else if (sum+1==primes.get(j)){
                if (kadeh1>0){
                    ans[i]=1;
                    kadeh1--;
                    sum++;
                    j++;
                }
                else if (kadeh2>0){
                    ans[i]=2;
                    kadeh2--;
                    sum+=2;
                    j++;
                }
            }
            if (j==primes.size()){
                for (int k=i+1;k<n;k++){
                    if (kadeh1>0){
                        ans[k]=1;
                        kadeh1--;
                    }
                    else if (kadeh2>0){
                        ans[k]=2;
                        kadeh2--;
                    }
                }
                break;
            }
        }
        for (int i=0;i<n;i++){
            out.print(ans[i]+" ");
        }

    }
}
