package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeMap;

public class EMinimumArray {

    static int getClosest(int val1, int val2,
                   int target)
    {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }

    static int findClosest(int n, int target)
    {
        if (target <= b[0])
            return b[0];
        if (target >= b[n - 1])
            return b[n - 1];

        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (b[mid] == target)
                return b[mid];

            if (target < b[mid]) {

                if (mid > 0 && target > b[mid - 1])
                    return getClosest(b[mid - 1],
                            b[mid], target);

                /* Repeat for left half */
                j = mid;
            }

            else {
                if (mid < n - 1 && target < b[mid + 1])
                    return getClosest(b[mid],
                            b[mid + 1], target);
                // update i
                i = mid + 1;
            }
        }

        // Only single element left after search
        return b[mid];
    }




    static Integer[] a,b;
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        a=new Integer[n];
        b=new Integer[n];

        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int x;
        for (int i=0;i<n;i++){
            x=sc.nextInt();
            map.putIfAbsent(x,0);
            map.put(x, map.get(x)+1);
        }
        int[] c=new int[n];
        int act;
        for (int i=0;i<n;i++){
            if (map.ceilingKey(n-a[i])==null){
                act=map.firstKey();
            }
            else {
                act = map.ceilingKey(n - a[i]);
            }
            if (map.get(act)>1){
                map.put(act,map.get(act)-1);
            }
            else{
                map.remove(act);
            }
            c[i]=(a[i]+act)%n;
        }
        for (int i=0;i<n;i++){
            out.print(c[i]+" ");
        }
    }
}
