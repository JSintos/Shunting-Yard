package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShuntingYard {
	public static String evaluateExpression(String expression) {
		String output = "";
		Stack<Character> operatorStack = new Stack<Character>();
		
		ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+", "-", "*", "/", "%", "^"));
		
		for(String e : expression.split("\\s")) {
			// Checks if the token is a number
			if(!operators.contains(e) && !(e.charAt(0) == '(') && !(e.charAt(0) == ')')) {
				output += e + " ";
			}
			// Checks if the token is an operator
			else if(operators.contains(e)) {
				if(operatorStack.empty() || (e.charAt(0) == '^' && operatorStack.peek() == '^')) {
					operatorStack.push(e.charAt(0));
				}
				else {
					while(!operatorStack.empty() && determineHigherPrecedence(e.charAt(0), operatorStack.peek()) == operatorStack.peek()) {
						output += operatorStack.pop() + " ";
					}
					
					operatorStack.push(e.charAt(0));
				}
			}
			// Checks if the token is a left parenthesis
			else if(e.charAt(0) == '(') {
				operatorStack.push(e.charAt(0));
			}
			// Checks if the token is a right parenthesis
			else if(e.charAt(0) == ')') {
				while(!(operatorStack.peek() == '(')) {
					output += operatorStack.pop() + " ";
				}
				
				operatorStack.pop();
			}
		}
		
		while(operatorStack.empty() == false) {
			output += operatorStack.pop() + " ";
		}
		
		return output;
	}
	
	public static char determineHigherPrecedence(char a, char b) {
		if(a == '+' || a == '-') {
			if(b == '+' || b == '-' || b == '*' || b == '/' || b == '%' || b == '^') {
				return b;
			}
		}
		
		if(a == '*' || a == '/' || a == '%') {
			if(b == '*' || b == '/' || b == '%' || b == '^') {
				return b;
			}
		}
		
		return a;
	}
}