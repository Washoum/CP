package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class AInscribedFigures {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] tab=new int[n];
        for(int i=0;i<n;i++){
            tab[i]=sc.nextInt();
        }

        for (int i=1;i<n;i++){
            if ((tab[i] == 2 || tab[i] == 3) && (tab[i - 1] == 2 || tab[i - 1] ==3)) {
                out.println("Infinite");
                return;
            }
        }
        int ans=0;
        for (int i=1;i<n;i++){
            if (tab[i]==1){
                if (tab[i-1]==2){
                    ans+=3;
                }
                else if (tab[i-1]==3){
                    ans+=4;
                }
            }
            else if (tab[i]==2){
                if (tab[i-1]==1){
                    if (i>1 && tab[i-2]==3){
                        ans+=2;
                    }else {
                        ans += 3;
                    }
                }
                else if (tab[i-1]==3){
                    out.println("Infinite");
                    return;
                }
            }
            else if (tab[i]==3){
                if (tab[i-1]==2){
                    out.println("Infinite");
                    return;
                }
                else if (tab[i-1]==1){
                    ans+=4;
                }
            }
        }
        out.println("Finite");
        out.println(ans);
    }
}
