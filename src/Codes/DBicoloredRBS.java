package Codes;

import FastIO.inputClass;
import java.io.PrintWriter;
import java.util.Stack;

public class DBicoloredRBS {
    public void solve(int testNumber, inputClass sc, PrintWriter out) {
        int n=sc.nextInt();
        String s=sc.nextLine();
        Stack<Integer> stack=new Stack<>();
        int next=0;
        int[] ans=new int[n];
        stack.push(0);
        for (int i=1;i<n;i++){
            if (stack.size()==0){
                stack.push(0);
                continue;
            }
            if (s.charAt(i)=='('){
                next=(stack.peek()+1)%2;
                stack.push(next);
                ans[i]=next;
            }
            else{
                ans[i]=stack.peek();
                stack.pop();
            }
        }
        for (int i=0;i<n;i++){
            out.print(ans[i]);
        }
    }
}
