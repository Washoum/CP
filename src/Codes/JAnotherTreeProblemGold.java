package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Arrays;

public class JAnotherTreeProblemGold {
    static final int mod= (int) 1e9+7;
    static int u,v;
    static int gcdExtended(int a, int b)
    {
        if (a == 0)
        {
            u=0;
            v=1;
            return b;
        }
        int gcd = gcdExtended(b%a, a);
        int tmp1=u,tmp2=v;
        u = tmp2 - (b/a) * tmp1;
        v = tmp1;
        return gcd;
    }

    static int pow(long x, long y, int p){
        long res = 1;
        x = x % p;
        while (y > 0) {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return (int)res;
    }

    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        long[] tab=new long[n];
        long[] prod=new long[n];
        prod[0]=1;
        tab[0]=1;
        for (int i=1;i<n;i++){
            tab[i]=sc.nextLong();
            prod[i]=(prod[i-1]*tab[i])%mod;
        }

//        long[][] intervalprod=new long[n+1][2*n];
//        for (int i=0;i<n;i++){
//            Arrays.fill(intervalprod[i],1);
//        }
//
//        for( int i=1;i<n;i++){
//            for (int j=i;j<n;j++){
//                intervalprod[i][j]=(intervalprod[i][j-1]*tab[j])%mod;
//            }
//            for (int j=n-i;j<2*n;j++){
//                intervalprod[i][j]=(intervalprod[i][j-1])%mod;
//            }
//        }
//        int[] inv=new int[n];
//        for (int i=0;i<n;i++){
//            gcdExtended((int)tab[i],mod);
//            inv[i]=(u%mod+mod)%mod;
//        }
        long[][] dp=new long[n+1][n+1];
        for (int i=1;i<n;i++){
            dp[i][1]=tab[i];
            dp[i][0]=1;
        }
        dp[n][0]=1;
        for (int i=n-1;i>=1;i--){
            for (int j=2;j<=n;j++){
                dp[i][j]=(dp[i+1][j-1]*tab[i])%mod;
            }
        }
        long ans;
        long toadd;
        long var;
        for (int i=1;i<2*n-1;i++){
            ans=0;
            for (int j=1;j<n;j++){
                if ((n-j)*2<i) break;
                if (i<n){
                    ans+=(prod[j-1]*dp[j][i])%mod;
                    ans%=mod;
                }

                toadd=0;
                for (int k=1;k<i/2 + ((i%2!=0)? 1 : 0);k++){
                    if (i-k-1<n) {
                        toadd += (dp[j + 1][i - k - 1] * (dp[j + 1][k - 1])) % mod;
                        toadd %= mod;
                    }
                }
                var = tab[j] * (tab[j] - 1)%mod;
                toadd*= var;
                toadd%=mod;
                if (i%2==0 && i/2-1<n){
                    toadd+=(((dp[j + 1][i/2-1] * (dp[j + 1][i/2-1]))%mod)*(var /2)%mod)%mod;
                    toadd%=mod;
                }
                ans+=(toadd*prod[j-1])%mod;
                ans%=mod;
            }
            out.print(ans+" ");
        }
//        for (int i=1;i<2*n-1;i++){
//            ans=0;
//            toadd=0;
//            for (int k=1;k<i/2 + ((i%2!=0)? 1 : 0);k++){
//                toadd += (dp[2][i - k - 1] * (dp[2][k - 1]))%mod;
//                toadd%=mod;
//            }
//            var = tab[1] * (tab[1] - 1)%mod;
//            toadd*= var;
//            toadd%=mod;
//            if (i%2==0){
//                toadd+=(((dp[2][i/2-1] * (dp[2][i/2-1]))%mod)*(var /2)%mod)%mod;
//                toadd%=mod;
//            }
//            ans+=(toadd*prod[0])%mod;
//            ans%=mod;
//            ans+=(prod[0]*dp[1][i])%mod;
//            ans%=mod;
//
//            for (int j=2;j<n;j++){
//                toadd*=pow(inv[j-1],2,mod);
//                toadd%=mod;
//                toadd*=intervalprod[j][i-1];
//                toadd%=mod;
//                ans+=(prod[j-1]*dp[j][i])%mod;
//                ans%=mod;
//                ans+=(toadd*prod[j-1])%mod;
//                ans%=mod;
//            }
//            out.print(ans+" ");
//        }
    }
}
