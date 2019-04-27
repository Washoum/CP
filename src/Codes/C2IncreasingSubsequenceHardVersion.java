package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class C2IncreasingSubsequenceHardVersion {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        ArrayList<Integer> tab=new ArrayList<>();
        for (int i=0;i<n;i++){
            tab.add(sc.nextInt());
        }
        StringBuilder ans=new StringBuilder();
        int l=0;
        int r=n-1;
        int act=0;
        if (tab.get(r).intValue()==tab.get(l)){
            int best;
            int a=1;
            for (int i=0;i<n-1;i++){
                if (tab.get(i)<tab.get(i+1)){
                    a++;
                }
                else{
                    break;
                }
            }
            best=a;
            a=1;
            for (int i=n-1;i>=1;i--){
                if (tab.get(i)<tab.get(i-1)){
                    a++;
                }
                else{
                    break;
                }
            }
            if (a>best){
                out.println(a);
                for (int i=0;i<a;i++){
                    out.print('R');
                }
            }
            else{
                out.println(best);
                for (int i=0;i<best;i++){
                    out.print('L');
                }
            }
            return;
        }
        else if (tab.get(l)>tab.get(r)){
            ans.append('R');
            act=tab.get(r);
            r--;
        }
        else{
            ans.append('L');
            act=tab.get(l);
            l++;
        }

        boolean mezel=true;
        while (mezel && r-l>=0){
            if (tab.get(l)<=act && tab.get(r)<=act){
                mezel=false;
            }
            else if (tab.get(l)>act && tab.get(r)>act){
                if (tab.get(l).intValue()==tab.get(r)){
                    int best=0;
                    int a=1;
                    for (int i=l;i<=r-1;i++){
                        if (tab.get(i)<tab.get(i+1)){
                            a++;
                        }
                        else{
                            break;
                        }
                    }
                    best=a;
                    a=1;
                    for (int i=r;i>=l+1;i--){
                        if (tab.get(i)<tab.get(i-1)){
                            a++;
                        }
                        else{
                            break;
                        }
                    }
                    if (best==0 && a==0){
                        best=1;
                    }
                    if (a>best){
                        for (int i=0;i<a;i++){
                            ans.append('R');
                        }
                    }
                    else{
                        for (int i=0;i<best;i++){
                            ans.append('L');
                        }
                    }
                    break;
                }
                else if (tab.get(l)<tab.get(r)){
                    ans.append('L');
                    act=tab.get(l);
                    l++;
                }
                else{
                    ans.append('R');
                    act=tab.get(r);
                    r--;
                }
            }
            else if (tab.get(l)>act){
                ans.append('L');
                act=tab.get(l);
                l++;
            }
            else{
                ans.append('R');
                act=tab.get(r);
                r--;
            }
        }

        out.println(ans.length());
        out.println(ans);

    }
}
