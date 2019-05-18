package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] tab=new int[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        int[] occp=new int[100001];
        int[] occimp=new int[100001];
        for (int i=0;i<n;i+=2){
            occp[tab[i]]++;
        }
        for (int i=1;i<n;i+=2){
            occimp[tab[i]]++;
        }
        int bestp=0, sbestp=0;
        int besti=0, sbesti=0;
        for (int i=1;i<100001;i++){
            if (occp[i]>occp[bestp]){
                sbestp=bestp;
                bestp=i;
            }
            else if (occp[i]>occp[sbestp]){
                sbestp=i;
            }

            if (occimp[i]>occimp[besti]){
                sbesti=besti;
                besti=i;
            }
            else if (occimp[i]>occimp[sbesti]){
                sbesti=i;
            }
        }
        int t1=bestp;
        int t2=besti;
        if (besti==bestp){
            if (occimp[besti]>occp[bestp]){
                t1=sbestp;
            }
            else if (occimp[besti]<occp[bestp]){
                t2=sbesti;
            }
            else{
                if (occimp[sbesti]>=occp[sbestp]){
                    t2=sbesti;
                }
                else{
                    t1=sbestp;
                }
            }
        }
        int ans=0;
        for (int i=0;i<n;i++){
            if (i%2==0){
                if (tab[i]!=t1){
                    ans++;
                }
            }
            else{
                if (tab[i]!=t2){
                    ans++;
                }
            }
        }
        out.println(ans);
    }
}
