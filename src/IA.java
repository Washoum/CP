import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Washoum
 */
public class IA {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            for (int cas = 0; cas < n; cas++) {
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double init1 = a;
                double init2 = b;
                int puis1 = 0, puis2 = 0;
                if (Math.abs(a-b)<0.0000000001){
                    out.println(2+" "+2);
                    continue;
                }

                a=a*100000;
                b=b*100000;
                int g = gcd((int) Math.round(a), (int) Math.round(b));
                if (checkprime((int) Math.round(a) / g) && checkprime((int) Math.round(b) / g)) {
                    out.println((int) Math.round(a) / g + " " + (int) Math.round(b) / g);
                } else {
                    out.println("impossible");
                }

            }
        }

        static boolean checkprime(int a) {
            if (a==1 || a==0){
                return false;
            }
            boolean prime = true;
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    prime = false;
                    break;
                }
            }
            return prime;
        }

        static int gcd(int a, int b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }

    }

    static class inputClass {
        BufferedReader br;
        StringTokenizer st;

        public inputClass(InputStream in) {

            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
