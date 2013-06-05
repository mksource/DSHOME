package com.probelms;

import java.util.Stack;

import com.design.utils.InputReader;
/**
 * 1.Create a Stack for operator and a Stack for operand
 * 2.Read the infix expression
 * 3.Read a character from infix expression
 * 		a.if the character is operand then push to the operand stack
 * 		b.if the character is (  then push onto the operator stack
 * 		c.if the character is operator
 *        i)if top of operator stack is ( then just push to stack
 *        ii)if precedence of operator on the top of the stack is less than precedence of this 
 *           operator then push to stack
 *        iii)otherwise get the operator from operator stack left operand and right operand 
 *            from the operand stack then form the prefix expression put to the operand stack
 *      d.if the character is ) then until we get ( pop the operator stack pop the left operand 
 *        and right operand from the operand stack form the prefix expression and push onto the 
 *        operand stack
 *      e.if the operator stack is not empty then pop operator from operator stack pop left and right 
 *        operand from operand stack form the prefix expression then push onto the operand stack
 *       f.pop the top of the operand stack to get the prefix expression             
 *
 */

public class InfixToPrefix {

	/**
	 * @param args
	 * 
	 */
	Stack<String> operatorStack;
	Stack<String> operandStack;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPrefix exp=new InfixToPrefix();
		exp.process();

	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/balexp.txt"));
		operatorStack=new Stack<String>();
		operandStack=new Stack<String>();
		String infix=in.readLine();
		
		for(int i=0;i<infix.length();i++) 
		{
			char ch=infix.charAt(i);
			switch(ch)
			{
					case '+':
					case '-':	
							 gotOper(ch);
							 break;
					case '*':
					case '/':gotOper(ch);	
							 break;
					case '(':operatorStack.push(String.valueOf(ch))	;
							 break;
					case  ')':gotParan();
							  break;
					default:operandStack.push(String.valueOf(ch));		  
			}
		}	
		while(!operatorStack.isEmpty())
		{
			String prefix="";
			String rightopr=operandStack.pop();
			String leftopr=operandStack.pop();
			String opTop=operatorStack.pop();
			prefix=opTop+leftopr+rightopr;
			operandStack.push(prefix);
		}
		
		String prefix=operandStack.pop();
		System.out.println(prefix);
	}
	public void gotOper(char opThis)
	{
		while(!operatorStack.isEmpty())
		{
			String opTop=operatorStack.pop();
			if(opTop.equals("("))
			{
				operatorStack.push(opTop);
				break;
			}
			else if(getPriority(opTop)<getPriority(String.valueOf(opThis)))
			{
				operatorStack.push(opTop);
				break;
			}
			else
			{
				String prefix="";
				String rightopr=operandStack.pop();
				String leftopr=operandStack.pop();
				prefix=opTop+leftopr+rightopr;
				operandStack.push(prefix);
			}
		}
		operatorStack.push(String.valueOf(opThis));
	}
	public void gotParan()
	{
		while(!operatorStack.isEmpty())
		{
			String prefix="";
			String ch=operatorStack.pop();
			if(ch.equals("("))break;
			
			String rightopr=operandStack.pop();
			String leftopr=operandStack.pop();
			prefix+=ch+leftopr+rightopr;
			operandStack.push(prefix);
		}
	}
	public int getPriority(String opr1)
	{
		if(opr1.equals("+") || opr1.equals("-"))return 1;
		else if(opr1.equals("*")||opr1.equals("/"))return 2;
		else return 1;
	}
}
