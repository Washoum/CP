package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class CMashaAndTwoFriends {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        long n=sc.nextLong();
        long m=sc.nextLong();

        long x1=sc.nextInt();
        long y1=sc.nextInt();

        long x2=sc.nextInt();
        long y2=sc.nextInt();

        long x3=sc.nextInt();
        long y3=sc.nextInt();

        long x4=sc.nextInt();
        long y4=sc.nextInt();

        long blanc=0;
        long noir=0;
        blanc=( (n*m)%2==1)? (n*m)/2+1 : (n*m)/2;
        noir= (n*m)/2;
        if ((x1%2==0 && y1%2==0) || (x1%2==1 && y1%2==1)){
            noir-=((x2-x1+1)*(y2-y1+1))/2;
            blanc+=((x2-x1+1)*(y2-y1+1))/2;
        }
        else {
            noir-=(((x2-x1+1)*(y2-y1+1))%2==1)? ((x2-x1+1)*(y2-y1+1))/2 +1 : ((x2-x1+1)*(y2-y1+1))/2;
            blanc+=(((x2-x1+1)*(y2-y1+1))%2==1)? ((x2-x1+1)*(y2-y1+1))/2 +1 : ((x2-x1+1)*(y2-y1+1))/2;
        }

        if (x3>=x1 && y3>=y1 && )


    }
}
