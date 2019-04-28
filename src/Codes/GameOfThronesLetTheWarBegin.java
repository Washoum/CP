package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class GameOfThronesLetTheWarBegin {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        while (t>0){
            t--;
            String s=sc.nextLine();
            int diff=0;
            HashMap<Character,Boolean> which=new HashMap<>();
            for (int i=0;i<s.length();i++){
                if (which.get(s.charAt(i))==null){
                    which.put(s.charAt(i),true);
                    diff++;
                }
            }
            HashMap<Character, Integer> map=new HashMap<>();
            map.put(s.charAt(0),1);
            int i=1;
            while (i<s.length() && s.charAt(i)==s.charAt(i-1) ) i++;
            if (i<s.length()){
                map.put(s.charAt(i),0);
                i++;
            }
            int cnt=2;
            for (;i<s.length();i++){
                if (map.get(s.charAt(i))==null){
                    map.put(s.charAt(i),cnt);
                    cnt++;
                }
            }
            long poly=1;
            long ans=0;
            for (int j=s.length()-1;j>=0;j--){
                ans+=poly*map.get(s.charAt(j));
                poly*=Math.max(2,diff);
            }
            out.println(ans);
        }
    }
}
