package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;

public class IKillOrSkipYellow {
    static class Room{
        int dmg;
        int ammo;
        long xp;
        int hp;
        int ra;
    }
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        Room[] rooms=new Room[n];
        for (int i=0;i<n;i++){
            rooms[i]=new Room();
            rooms[i].dmg=sc.nextInt();
            rooms[i].ammo=sc.nextInt();
            rooms[i].xp=sc.nextInt();
            rooms[i].hp=sc.nextInt();
            rooms[i].ra=sc.nextInt();
        }

        long[][][][] dp=new long[n+1][101][101][2];
        boolean[][][][] go=new boolean[n+1][101][101][2];
        go[0][100][100][0]=true;
        for (int i=0;i<n;i++){
            for (int j=0;j<=100;j++){
                for (int k=0;k<=100;k++) {
                    for (int l = 0; l < 2; l++) {
                        if (go[i][j][k][l]) {
                            dp[i + 1][j][k][l] = Math.max(dp[i][j][k][l], dp[i + 1][j][k][l]);
                            go[i+1][j][k][l]=true;
                            if (rooms[i].dmg < j && rooms[i].ammo <= k) {
                                dp[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l] =
                                        Math.max(dp[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l],
                                                dp[i][j][k][l] + rooms[i].xp);
                                go[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l] =true;
                                if (l < 1) {
                                    dp[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l + 1] =
                                            Math.max(dp[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l + 1],
                                                    dp[i][j][k][l] + (rooms[i].xp * rooms[i].xp));
                                    go[i + 1][Math.min(j - rooms[i].dmg + rooms[i].hp, 100)][Math.min(100, k - rooms[i].ammo + rooms[i].ra)][l+1]=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        long ans=0;
        for (int i=0;i<=100;i++){
            for (int j=0;j<=100;j++){
                for (int k=0;k<2;k++){
                    ans=Math.max(ans,dp[n][i][j][k]);
                }
            }
        }
        out.println(ans);
    }
}
