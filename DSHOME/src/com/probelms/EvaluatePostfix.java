package com.probelms;

import java.util.Stack;

public class EvaluatePostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InfixToPostfix exp=new InfixToPostfix();
		exp.process();
		EvaluatePostfix eval=new EvaluatePostfix();
		eval.process(exp.output.toString());
	}
	public void process (String postfix)
	{
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<postfix.length();i++)
		{
			char ch=postfix.charAt(i);
			switch(ch)
			{
					case '+':
					case '-':
					case '*':
					case '/':
							 int rightopr=stack.pop();
							 int leftopr=stack.pop();
						     int result=eval(rightopr, leftopr, ch);
						     stack.push(result);
						     break;
				   default:stack.push(Character.getNumericValue(ch));		     
							 
			}
		}
		System.out.println("The result of evaluation of postfix expression is"+stack.pop());
		
	}
	public int eval(int rightopr,int leftopr,char opr)
	{
		if(opr=='+')
			return leftopr+rightopr;
		else if(opr=='-')
			return leftopr-rightopr;
		else if(opr=='*')
			return leftopr*rightopr;
		else
			return leftopr/rightopr;
	}

}
