package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class BienvenueAuChackathon {
    static int count(String a, String b)
    {
        int m = a.length();
        int n = b.length();

        int lookup[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            lookup[0][i] = 0;
        for (int i = 0; i <= m; ++i)
            lookup[i][0] = 1;

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] +
                            lookup[i - 1][j];
                }

                else {
                    lookup[i][j] = lookup[i - 1][j];
                }
                lookup[i][j]%=10000;
            }
        }
        return lookup[m][n];
    }


    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int t=sc.nextInt();
        String b="bienvenue au chackathon";
        while (t>0){
            t--;
            String a=sc.nextLine();
            StringBuilder ans=new StringBuilder(String.valueOf(count(a,b)));
            while (ans.length()<4){
                ans.insert(0,'0');
            }

            out.println(ans);
        }
    }
}
