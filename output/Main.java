import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Washoum
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BNekoPerformsCatFurrierTransform solver = new BNekoPerformsCatFurrierTransform();
        solver.solve(1, in, out);
        out.close();
    }

    static class BNekoPerformsCatFurrierTransform {
        static int pow(int a, int p) {
            int x = 1;
            for (int i = 0; i < p; i++) {
                x *= a;
            }
            return x;
        }

        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            ArrayList<Integer> ans = new ArrayList<>();
            boolean first = true;
            int nb = 0;
            for (int i = 20; i >= 0; i--) {
                if ((n & 1 << i) > 0 && first) {
                    first = false;
                } else if ((n & 1 << i) == 0 && !first) {
                    ans.add(i + 1);
                    nb++;
                    n ^= (pow(2, i + 1) - 1);
                    int tmp = n + 1;
                    while (tmp % 2 == 0) {
                        tmp /= 2;
                    }
                    if (tmp == 1) {
                        break;
                    }
                    n++;
                    ans.add(-1);
                    nb++;
                    tmp = n + 1;
                    while (tmp % 2 == 0) {
                        tmp /= 2;
                    }
                    if (tmp == 1) {
                        break;
                    }
                }
                //11110100001001000000

            }
            out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                if (i % 2 == 0) {
                    out.print(ans.get(i) + " ");
                }
            }
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

    }
}

