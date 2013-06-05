package com.probelms;

import java.util.Stack;

import com.design.utils.InputReader;

/**
 *To convert from infix to postfix expression 
 *
 *		1. create a stack
 *		2. for each character in the infix expression do the following
 *			a.If the character is alphabet or number just output number 
 *			b.If the character is left parenthesis then push onto the stack
 *			c.If the character id right parenthesis then pop from the stack and print 
 *			  it to output until we encounter the left parenthesis
 *			d.If the character is a operator then pop from the stack unitl we encounter lower priority
 *			  operator or left parenthesis or stack is empty
 *		3.pop and output the token until  the stack is empty
 *
 */

	

public class InfixToPostfix {

	/**
	 * @param args
	 * 
	 */
	public StringBuffer output;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPostfix inpos=new InfixToPostfix();
		inpos.process();

	}
	public void process()
	{
		output=new StringBuffer();
		InputReader in=new InputReader(getClass().getResourceAsStream("/balexp.txt"));
		Stack<Character> stack=new Stack<Character>();
		String infix=in.readLine();
		
		for(int i=0;i<infix.length();i++)
		{
			char ch=infix.charAt(i);
			switch(ch)
			{
					case '+':
					case '-':
							 getOper(stack,ch,getPriority(ch));
							 break;
					case '/':
					case '*':
							 getOper(stack,ch,getPriority(ch));
							 break;	
					case '(':stack.push(ch);
							 break;
					case ')':
							 gotParen(stack);
							 break;
					default:output.append(ch);		 
			}
		}
		while(!stack.isEmpty())
		{
			output.append(stack.pop());
		}
	}
	public void getOper(Stack<Character> stack,char opThis,int prec1)
	{
		while(!stack.isEmpty())
		{
			char opTop=stack.pop();
			if(opTop=='(')
			{
				stack.push(opTop);
				break;
			}
			else
			{
				if(getPriority(opTop)<getPriority(opThis))
				{
					stack.push(opTop);
					break;
				}
				else
					output.append(opTop);
			}
		}
		stack.push(opThis);
	}
	public void gotParen(Stack<Character> stack)
	{
		while(!stack.isEmpty())
		{
			char ch=stack.pop();
			if(ch=='(')break;
			else output.append(ch);
		}
	}
	public int getPriority(char ch)
	{
		if(ch=='+' || ch=='-')return 1;
		return 2;
	}

}
