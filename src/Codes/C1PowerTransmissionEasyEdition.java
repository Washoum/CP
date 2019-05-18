package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Double.NaN;

public class C1PowerTransmissionEasyEdition {
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        for (int i=0;i<n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        HashMap<Double, ArrayList<Double>> slopes=new HashMap<>();
        ArrayList<Double> tmp;
        double slope;
        long nblines=0;
        long ans=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                slope=(double)(y[i]-y[j])/(x[i]-x[j]);
                slope=Double.valueOf(String.format("%.9f",slope));
                slopes.putIfAbsent(slope,new ArrayList<>());
                tmp=slopes.get(slope);
                boolean found=false;
                double orr=y[j]-(slope*x[j]);
                orr=Double.valueOf(String.format("%.9f",orr));
                for (int k=0;k<tmp.size();k++){
                    if (Double.isNaN(tmp.get(k)) && Double.isNaN(orr)){
                        found=true;
                        break;
                    }
                    if (Double.isInfinite(tmp.get(k)) && Double.isInfinite(orr)){
                        found=true;
                        break;
                    }
                    if (Math.abs(tmp.get(k)-orr)<=0.000000001){
                        found=true;
                        break;
                    }
                }
                tmp.add(orr);
                if (!found){
                    nblines++;
                    ans+=nblines-tmp.size();
                }
            }
        }
        if (nblines==1){
            out.println(0);
            return;
        }
        out.println(ans);
//        Iterator<Map.Entry<Double,ArrayList<Double>>> it=slopes.entrySet().iterator();
//        Map.Entry<Double,ArrayList<Double>> t;
//        long ans=0;
//        while (it.hasNext()){
//            t=it.next();
//            ans+=(long)(t.getValue().size())*(nblines-(long)(t.getValue().size()));
//        }
//        out.println(ans/2);

    }
}
