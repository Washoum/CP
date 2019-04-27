package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class DNProblemsDuringKDays {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        if (k==1){
            out.println("YES");
            out.println(n);
            return;
        }
        long sum=(long) k*(2+k-1)/2;
        if (sum>n){
            out.println("NO");
            return;
        }
        int start=1;
        while (sum<n){
            start++;
            sum=(long) k*(start+start+k-1)/2;
        }
        long[] ans=new long[k];
        for (int i=0;i<k;i++){
            ans[i]=start+i;
        }
        if (sum==n){
            out.println("YES");
            for (int i=0;i<k;i++){
                out.print(ans[i]+" ");
            }
            return;
        }
        if (start!=2) {
            ans[0]--;
            sum--;
            if (sum == n) {
                out.println("YES");
                for (int i = 0; i < k; i++) {
                    out.print(ans[i] + " ");
                }
                return;
            }
            int i = 1;
            while (sum > n && i<k) {
                if (sum-ans[i]-ans[i-1]-1>n){
                    sum-=ans[i]-ans[i-1]-1;
                    ans[i]=ans[i-1]+1;
                }
                else{
                    ans[i]=n+ans[i]-sum;
                    break;
                }
                i++;
            }
            out.println("YES");
            for (int j = 0; j < k; j++) {
                out.print(ans[j] + " ");
            }
        }
        else{
            ans[0]--;
            ans[1]--;
            sum-=2;
            if (sum == n) {
                out.println("YES");
                for (int i = 0; i < k; i++) {
                    out.print(ans[i] + " ");
                }
                return;
            }
            if (sum<n){
                ans[k-1]++;
                out.println("YES");
                for (int i = 0; i < k; i++) {
                    out.print(ans[i] + " ");
                }
                return;
            }
            int i = 2;
            while (sum > n && i<k) {
                if (sum-ans[i]-ans[i-1]-1>n){
                    sum-=ans[i]-ans[i-1]-1;
                    ans[i]=ans[i-1]+1;
                }
                else{
                    ans[i]=n+ans[i]-sum;
                    break;
                }
                i++;
            }
            out.println("YES");
            for (int j = 0; j < k; j++) {
                out.print(ans[j] + " ");
            }
        }
    }
}
