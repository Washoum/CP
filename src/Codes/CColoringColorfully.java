package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class CColoringColorfully {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        String s=sc.nextLine();
        int nb0=0;
        int nb1=0;
        int tawa1=0;
        int tawa2=1;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)-'0'!=tawa1){
                nb0++;
            }
            if (s.charAt(i)-'0' != tawa2){
                nb1++;
            }
            tawa1=(tawa1+1)%2;
            tawa2=(tawa2+1)%2;
        }
        out.println(Math.min(nb0,nb1));
    }
}
