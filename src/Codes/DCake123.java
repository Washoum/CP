package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DCake123 {
    static int x,y,z,k;
    static Long[] a,b,c;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        k=sc.nextInt();
        a=new Long[x];
        b=new Long[y];
        c=new Long[z];
        for (int i=0;i<x;i++){
            a[i]=sc.nextLong();
        }
        for (int i=0;i<y;i++){
            b[i]=sc.nextLong();
        }
        for (int i=0;i<z;i++){
            c[i]=sc.nextLong();
        }
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());
        Arrays.sort(c, Collections.reverseOrder());
        long bord=0;
        long l=1;
        long r=(long)1e11;
        while (r-l>=0){
            long mid=(l+r)/2;
            if (check(mid)){
                bord=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        ArrayList<Long> ans=new ArrayList<>();
        for (int i=0;i<x;i++){
            if (a[i]+b[0]+c[0]<bord) continue;
            for (int j=0;j<y;j++){
                for (int t=0;t<z;t++){
                    if (a[i]+b[j]+c[t]>=bord){
                        ans.add(a[i]+b[j]+c[t]);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        ans.sort(Collections.reverseOrder());
        for (int i=0;i<k;i++){
            out.println(ans.get(i));
        }
    }

    static boolean check(long mid){
        int nb=0;
        for (int i=0;i<x;i++){
            if (a[i]>=mid){
                nb+=z*y;
                if (nb>=k) return true;
            }
            else if (a[i]+b[0]+c[0]<mid) break;
            else {
                for (int j = 0; j < y; j++) {
                    if (a[i] + b[j] >= mid) {
                        nb += z;
                        if (nb >= k) return true;
                    } else {
                        for (int l = 0; l < z; l++) {
                            if (a[i] + b[j] + c[l] >= mid) {
                                nb++;
                            } else {
                                break;
                            }
                            if (nb >= k) return true;
                        }
                    }
                }
            }
        }
        return nb >= k;
    }
}
