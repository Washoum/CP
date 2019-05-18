package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BLostNumbers {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int[] prod=new int[6];
        for (int i=2;i<=5;i++){
            out.println("? 1 "+i);
            out.flush();
            prod[i-2]=sc.nextInt();
        }
        int[] ans=new int[6];
        int nb=0;
        int last=-1;
        for (int i=0;i<4;i++){
            if (prod[i]%5==0){
                nb++;
                last=i;
            }
        }
        if (nb==0){
            ans[5]=15;
            for (int i=0;i<4;i++){
                if (prod[i]%23==0){
                    nb++;
                    last=i;
                }
            }
            if (nb>1){
                ans[0]=23;
                for (int i=1;i<5;i++){
                    ans[i]=prod[i-1]/23;
                }
            }
            else{
                ans[0]=prod[0]/23;
                for (int i=1;i<5;i++){
                    ans[i]=prod[i-1]/23;
                }
            }
        }
        else{
            ans[0]=prod[0]/15;
            for (int i=1;i<5;i++){
                ans[i]=prod[i-1]/15;
            }
        }
        ArrayList<Integer> tab=new ArrayList<>();
        tab.add(4);
        tab.add(8);
        tab.add(15);
        tab.add(16);
        tab.add(23);
        tab.add(42);
        for (int i=0;i<5;i++){
            for (int j=0;j<tab.size();j++){
                if (tab.get(j)==ans[i]){
                    tab.remove(j);
                    j--;
                }
            }
        }
        out.print("! ");
        ans[5]=tab.get(0);
        for (int i=0;i<6;i++){
            out.print(ans[i]+" ");
        }
    }
}
