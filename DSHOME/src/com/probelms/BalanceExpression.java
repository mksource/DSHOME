package com.probelms;

import java.util.Stack;

import com.design.utils.InputReader;

public class BalanceExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BalanceExpression exp=new BalanceExpression();
		if(exp.process()==0)
		{
			System.out.println("Expression is balanced");
		}
		else
		{
			System.out.println("Expression is not balanced");
		}

	}
	public int process()
	{
		Stack<Character> stack=new Stack<Character>();
		InputReader in=new InputReader(getClass().getResourceAsStream("/balexp.txt"));
		String line=in.readLine();
		
		for(int i=0;i<line.length();i++)
		{
			char ch=line.charAt(i);
			switch(ch)
			{
					case '(':
					case '[':
					case '{':stack.push(ch);
							 break;
					case  ']':
					case  '}':	
					case  ')':if(!stack.isEmpty())
							{
								char top=stack.pop();
								if(!doesMatch(top,ch))
									return -1;
								break;
							}
							else
							{
								return -1;
							}
					default:break;
							   	
						
			}
		}
		return 0;
	}
	
	public boolean doesMatch(char ch1,char ch2)
	{
		if(ch1=='(' && ch2==')')return true;
		else if(ch1=='{' && ch2=='}')return true;
		else if(ch1=='[' && ch2==']')return true;
		else return false;
	}

}
