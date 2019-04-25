import java.util.*;
import java.lang.*;
import java.io.*;



public class Main {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));

        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static String decodage_cesar(String mot, int cle){
        StringBuilder rep=new StringBuilder();
        int tmp;
        for (int i=0;i<mot.length();i++){
            tmp=mot.charAt(i)-cle-'a';
            if (tmp<0)
                tmp+=26;
            rep.append((char) (tmp+'a'));
        }
        return rep.toString();
    }

    public static String codage_cesar(String mot, int cle){
        StringBuilder rep=new StringBuilder();
        int tmp;
        for (int i=0;i<mot.length();i++){
            tmp=(mot.charAt(i)+cle-'a')%26;
            rep.append((char) (tmp+'a'));
        }
        return rep.toString();
    }

  public static void sauvegarde_mot(String inputFile, int key, String mode,String newFile) throws IOException {

      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      StringTokenizer st=new StringTokenizer(br.readLine());
      PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(newFile,true)));
      String mot=st.nextToken();
      if (mode.equals("Coder")){
          pw.println(codage_cesar(mot,key));
      }
      else if (mode.equals("Decoder")){
          pw.println(decodage_cesar(mot,key));
      }
      pw.close();
  }

    public static void main (String[] args) throws IOException {
        FastReader sc=new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //sauvegarde_mot("C:\\Users\\HP\\Desktop\\input.txt",2,"Coder","C:\\Users\\HP\\Desktop\\output.txt");
        out.println(-6%4);
        out.close();
    }


}