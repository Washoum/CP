package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B2CatPartyHardEdition {
    static int n;
    static int[] tab;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        n=sc.nextInt();
        tab=new int[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        int[] occ=new int[100005];
        HashMap<Integer,Integer> kadeh=new HashMap<>();
        HashMap<Integer,Integer> in=new HashMap<>();
        int maxocc=0;
        kadeh.put(0,0);
        int ans=0;
        for (int i=0;i<n;i++){
            in.putIfAbsent(tab[i],0);
            if (occ[tab[i]]==0){
                occ[tab[i]]++;
                kadeh.putIfAbsent(1,0);
                kadeh.put(1, kadeh.get(1)+1);
            }
            else{
                kadeh.putIfAbsent(occ[tab[i]],0);
                kadeh.put(occ[tab[i]],kadeh.get(occ[tab[i]])-1);
                occ[tab[i]]++;
                kadeh.putIfAbsent(occ[tab[i]],0);
                kadeh.put(occ[tab[i]],kadeh.get(occ[tab[i]])+1);
            }
            if (occ[tab[i]]>maxocc){
                maxocc=occ[tab[i]];
            }

            if (maxocc==1){
                ans=i+1;
            }
            else if (maxocc==2 && kadeh.get(maxocc)==1){
                ans=i+1;
            }
            else if (kadeh.get(maxocc-1)==in.size()-1 && kadeh.get(maxocc)==1){
                ans=i+1;
            }
            else if (kadeh.get(maxocc)==in.size()-1 && kadeh.get(1)==1){
                ans=i+1;
            }
        }
        out.println(ans);
    }

}
