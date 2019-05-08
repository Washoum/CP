package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DThreeReligions {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int[] freq=new int[26];
        int n=sc.nextInt();
        int q=sc.nextInt();
        String s=sc.nextLine();
        for (int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }

        HashMap<Character, Integer> reg1=new HashMap<>();
        HashMap<Character, Integer> reg2=new HashMap<>();
        HashMap<Character, Integer> reg3=new HashMap<>();
        for (int i=0;i<26;i++){
            reg1.put((char)(i+'a'),0);
            reg2.put((char)(i+'a'),0);
            reg3.put((char)(i+'a'),0);
        }
        ArrayList<Character> last1=new ArrayList<>();
        ArrayList<Character> last2=new ArrayList<>();
        ArrayList<Character> last3=new ArrayList<>();
        char t;
        int x;
        char c;
        String[] line;
        loop :for (int i=0;i<q;i++){
            line=sc.nextLine().split(" ");
            t=line[0].charAt(0);
            if (t=='+'){
                x=Integer.parseInt(line[1]);
                c=line[2].charAt(0);
                if (x==1){
                    reg1.put(c,reg1.get(c)+1);
                    last1.add(c);
                }
                else if (x==2){
                    reg2.put(c,reg2.get(c)+1);
                    last2.add(c);
                }
                else{
                    reg3.put(c,reg3.get(c)+1);
                    last3.add(c);
                }
            }
            else{
                x=Integer.parseInt(line[1]);
                if (x==1){
                    reg1.put(last1.get(last1.size()-1),reg1.get(last1.get(last1.size()-1))-1);
                    last1.remove(last1.size()-1);
                }
                else if (x==2){
                    reg2.put(last2.get(last2.size()-1),reg2.get(last2.get(last2.size()-1))-1);
                    last2.remove(last2.size()-1);
                }
                else{
                    reg3.put(last3.get(last3.size()-1),reg3.get(last3.get(last3.size()-1))-1);
                    last3.remove(last3.size()-1);
                }
            }
            for (int j=0;j<26;j++){
                int sum=0;
                sum+=reg1.get((char)('a'+j));
                sum+=reg2.get((char)('a'+j));
                sum+=reg3.get((char)('a'+j));
                if (sum>freq[j]){
                    out.println("NO");
                    continue loop;
                }
            }
            out.println("YES");
        }
    }
}
