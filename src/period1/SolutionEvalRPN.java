package period1;

import java.util.Stack;

public class SolutionEvalRPN {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> sNumber=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+")){
        		int i1=sNumber.pop();
        		int i2=sNumber.pop();
        		int temp=i1+i2;
        		sNumber.push(temp);
        	}
        	else if(tokens[i].equals("-")){
        		int i1=sNumber.pop();
        		int i2=sNumber.pop();
        		int temp=i2-i1;
        		sNumber.push(temp);
        	}
        	else if(tokens[i].equals("*")){
        		int i1=sNumber.pop();
        		int i2=sNumber.pop();
        		int temp=i1*i2;
        		sNumber.push(temp);
        	}
        	else if(tokens[i].equals("/")){
        		int i1=sNumber.pop();
        		int i2=sNumber.pop();
        		int temp=i2/i1;
        		sNumber.push(temp);
        	}
        	else{
        		int temp=Integer.parseInt(tokens[i]);
        		sNumber.push(temp);
        	}
        }
        return sNumber.pop();
    }
	public static void main(String[] args){
		String[] s={"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(s));
	}
}
