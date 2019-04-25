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
public class OthersCode {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CTreeDiameter solver = new CTreeDiameter();
        solver.solve(1, in, out);
        out.close();
    }

    static class CTreeDiameter {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int t = sc.nextInt();
            while (t > 0) {
                t--;
                int n = sc.nextInt();
                StringBuilder p = new StringBuilder();
                out.print("1 " + (n - 1) + " 1 ");
                ArrayList<Integer> rest = new ArrayList<>();
                for (int i = 2; i <= n; i++) {
                    out.print(i + " ");
                    rest.add(i);
                }
                out.flush();
                int longest = sc.nextInt();
                int x, mid;
                ArrayList<Integer> tmp;
                while (rest.size() > 1) {
                    mid = rest.size() / 2;
                    out.print("1 " + mid + " 1 ");
                    for (int i = 0; i < mid; i++) {
                        out.print(rest.get(i) + " ");
                    }
                    out.flush();
                    x = sc.nextInt();
                    if (x == longest) {
                        tmp = new ArrayList<>();
                        for (int i = 0; i < mid; i++) {
                            tmp.add(rest.get(i));
                        }
                        rest = tmp;
                    } else {
                        tmp = new ArrayList<>();
                        for (int i = mid; i < rest.size(); i++) {
                            tmp.add(rest.get(i));
                        }
                        rest = tmp;
                    }
                }
                out.print(1 + " " + (n - 1) + " " + rest.get(0) + " ");
                for (int i = 1; i <= n; i++) {
                    if (i != rest.get(0))
                        out.print(i + " ");
                }
                out.flush();
                x = sc.nextInt();
                out.println("-1 " + x);


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

