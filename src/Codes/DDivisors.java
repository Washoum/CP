package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DDivisors {

    static long gcd(long a , long b){
        if (b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        long [] tab=new long[n];
        for (int i=0;i<n;i++) {
            tab[i] = sc.nextLong();
        }
        HashMap<Long,Long> map=new HashMap<>();
        long x;
        long toadd=0;
        long ans=1;
        for (int i=0;i<n;i++){
            if (tab[i]==0) continue;
            if (Math.sqrt(Math.sqrt(tab[i]))==Math.round(Math.sqrt(Math.sqrt(tab[i])))){
                map.putIfAbsent((long)Math.sqrt(Math.sqrt(tab[i])),0L);
                map.put((long)Math.sqrt(Math.sqrt(tab[i])),map.get((long)Math.sqrt(Math.sqrt(tab[i])))+4);
            }
            else if (Math.sqrt(tab[i])==Math.round(Math.sqrt(tab[i]))) {
                map.putIfAbsent((long) Math.sqrt(tab[i]), 0L);
                map.put((long) Math.sqrt(tab[i]), map.get((long) Math.sqrt(tab[i])) + 2);
            }
            else if (Math.pow(tab[i],1d/3)==Math.round(Math.pow(tab[i],1d/3))){
                map.putIfAbsent((long)Math.pow(tab[i],1d/3),0L);
                map.put((long)Math.pow(tab[i],1d/3),map.get((long)Math.pow(tab[i],1d/3))+3);
            }
            else{
                boolean found=false;
                long equal=1;
                for (int j=0;j<n;j++){
                    if (j!=i){
                        if (tab[i]==tab[j])
                            equal++;
                        else {
                            x = gcd(tab[i], tab[j]);
                            if (x > 1) {
                                found = true;
                                map.putIfAbsent(tab[i] / x, 0L);
                                map.put(tab[i] / x, map.get(tab[i] / x) + 1);
                                map.putIfAbsent(x, 0L);
                                map.put(x, map.get(x) + 1);
                                break;
                            }
                        }
                    }
                }
                if (!found){
                    if (equal>1){
                        for(int j=i+1;j<n;j++){
                            if (tab[i]==tab[j]){
                                tab[j]=0;
                            }
                        }
                        ans*=(equal+1)*(equal+1);
                        ans%=998244353;
                    }
                    else {
                        toadd += 2;
                    }
                }
            }
        }

        Iterator<Map.Entry<Long,Long>> it=map.entrySet().iterator();
        Map.Entry<Long,Long> t;
        while (it.hasNext()){
            t=it.next();
            ans*=(t.getValue()+1);
            ans%=998244353;
        }

        for (int i=0;i<toadd;i++){
            ans*=2;
            ans%=998244353;
        }
        out.println(ans);
    }
}
