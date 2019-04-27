package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class FMaximumBalancedCircle {
    static Integer[] tab;
    static int n;
    static ArrayList<Integer> perm;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        n=sc.nextInt();
        tab=new Integer[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }
        Arrays.sort(tab);
        int l=1;
        int r=n;
        int ans=-1;
        while (r-l>=0){
            int mid=(l+r)/2;

            if (check(mid)) {
                l=mid+1;
                ans=mid;
            }
            else{
                r=mid-1;
            }
        }
        out.println(perm.size());
        for (int i=0;i<perm.size();i++){
            out.print(perm.get(i)+" ");
        }
    }

    static boolean check(int a){
        HashMap<Integer,Integer> map=new HashMap<>();
        LinkedList<Integer> tmp=new LinkedList<>();
        for (int i=0;i<a;i++){
            tmp.add(tab[i]);
            map.putIfAbsent(tab[i],0);
            map.put(tab[i],map.get(tab[i])+1);
        }
        if (tmp.peekLast()-tmp.peekFirst()==2 && map.get(tmp.peekLast())-1>2){
            perm=new ArrayList<>(tmp);
            return true;
        }
        else if (tmp.peekLast()-tmp.peekFirst()<2){
            perm=new ArrayList<>(tmp);
            return true;
        }
        int i=a;
        int act;
        while (i<n){
            act=tmp.pollFirst();
            map.put(act,map.get(act)-1);
            tmp.addLast(tab[i]);
            map.putIfAbsent(tab[i],0);
            map.put(tab[i],map.get(tab[i])+1);
            if (tmp.peekLast()-tmp.peekFirst()==2 && map.get(tmp.peekLast())-1>2){
                perm=new ArrayList<>(tmp);
                return true;
            }
            else if (tmp.peekLast()-tmp.peekFirst()<2){
                perm=new ArrayList<>(tmp);
                return true;
            }
            i++;
        }
        return false;
    }
}
