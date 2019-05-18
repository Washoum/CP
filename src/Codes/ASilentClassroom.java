package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.HashMap;

public class ASilentClassroom {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        String[] tab=new String[n];
        for (int i=0;i<n;i++){
            tab[i]=sc.nextLine();
        }
        HashMap<Character,Integer> class1=new HashMap<>();
        HashMap<Character,Integer> class2=new HashMap<>();

        for (char i='a';i<='z';i++){
            class1.put(i,0);
            class2.put(i,0);
        }

        for (int i=0;i<n;i++){
            if (class1.get(tab[i].charAt(0))<=class2.get(tab[i].charAt(0))){
                class1.put(tab[i].charAt(0),class1.get(tab[i].charAt(0))+1);
            }
            else{
                class2.put(tab[i].charAt(0),class2.get(tab[i].charAt(0))+1);
            }
        }
        long ans=0;
        for (char i='a';i<='z';i++){
            ans+=(class1.get(i)*(class1.get(i)-1))/2;
            ans+=(class2.get(i)*(class2.get(i)-1))/2;
        }
        out.println(ans);

    }
}
