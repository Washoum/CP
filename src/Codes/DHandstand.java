package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DHandstand {
    static class Pair{
        int x,y;
        Pair (int a, int b){
            x=a;
            y=b;
        }
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        String s=sc.nextLine();
        ArrayList<Pair> p=new ArrayList<>();
        if (s.charAt(0)-'0'==0){
            p.add(new Pair(1,0));
        }
        p.add(new Pair(s.charAt(0)-'0',1));
        for (int i=1;i<n;i++){
            if (s.charAt(i)-'0'==p.get(p.size()-1).x){
                p.get(p.size()-1).y++;
            }
            else{
                p.add(new Pair(s.charAt(i)-'0',1));
            }
        }
        long sum=0;
        int i;
        for (i=0;i<p.size();i++){
            if (p.get(i).x==0 && k==0) break;
            if (p.get(i).x==0){
                k--;
            }
            sum+=p.get(i).y;
        }
        int start=0;
        int end=i-1;
        long ans=sum;
        while (start < p.size() && end<p.size()){
            if (p.get(start).x==0){
                sum-=p.get(start).y;
                if (end<p.size()-2){
                    sum+=p.get(end+1).y;
                    sum+=p.get(end+2).y;
                    end+=2;
                    start++;
                }
                else if (end<p.size()-1){
                    sum+=p.get(end+1).y;
                    end++;
                    start++;
                }
                else{
                    end++;
                }
            }
            else{
                sum-=p.get(start).y;
                start++;
            }
            ans=Math.max(ans,sum);
        }
        out.println(ans);
    }
}
