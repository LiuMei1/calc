package com.niuniu.calc;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Todo {

	Stack<String> stack;

	// 表达式字符串
	String expression = null;
	
	private Pattern patten = Pattern.compile("//d//.?//d?");

	// 操作数一
	double figureOne = 0;
	// 操作数二
	double figureTwo = 0;
	// 两操作数结果
	double figureT = 0;
	// 一个随机当做参数的字符
	char randomChar;

	public Todo(String expression) {

		this.expression = expression;
		stack = new Stack<String>();
	}

	public String countExpression() {
		// 表达式字符串的当前索引
		int currentIndex = 0;
		// 上次字符串索引
		int lastIndex = 0;
		// 运算结果
		String result = null;
		// 当前字符
		char currentChar;

		int n = expression.length();
		if (n == 0) {
			System.out.println("表达式不能为空！");
		}

		// 表达式不为空，进行计算
		while (currentIndex <= n - 1) {
			currentChar = expression.charAt(currentIndex);
			// 如果表达式为数字，索引自加
			if (Character.isDigit(currentChar) || currentChar == '.') {
				currentIndex++;
			} else {

				if (currentIndex == 0) {

					System.out.println("表达式不正确！！");
				}
				// 表达式不为数字

				// 将数字传入栈中
				// 栈为空，传入数字
				if (stack.empty()) {
					stack.push(expression
							.substring(lastIndex, currentIndex - 1));
					lastIndex = currentIndex - 1;
				} else if (!isNum(stack.peek())) {
					// 栈顶为符号，拿出符号传入数字
					String st = stack.pop();
					stack.push(expression
							.substring(lastIndex, currentIndex - 1));
					lastIndex = currentIndex - 1;
					stack.push(st);
				} else {
					// 栈顶不为符号，传入数字

					stack.push(expression
							.substring(lastIndex, currentIndex - 1));
					lastIndex = currentIndex - 1;
				}

				// ***************************************************************

				// 如果栈顶为数字，直接将符号传入
				if (isNum(stack.peek())) {
					stack.push(expression.substring(lastIndex, currentIndex));
				} else {
					//判断栈顶符号
					switch (currentChar) {
					case '+':
						handleAddAndSubtract("+");
						break;
					case '-':
						handleAddAndSubtract("-");
						break;
					case '*':
						handleMultiplyAndDivide("*");
						break;
					case '/':
						handleMultiplyAndDivide("/");
						break;
					case '%':
						break;
					case '=':
						handleAddAndSubtract("=");
						
					}
				}
				lastIndex = lastIndex + 1;
				currentIndex = currentIndex + 1;

			}
		}

		result = stack.pop();
		stack.clear();
		return result;
	}

	private void handleAddAndSubtract(String c) {

		String st = stack.peek();
		figureOne = 7;//Double.valueOf(stack.peek());
		figureTwo =8;// Double.valueOf(stack.peek());
		switch (st) {
		case "+":
			figureT = figureOne + figureTwo;
			break;
		case "-":
			figureT = figureOne - figureTwo;
			break;
		case "*":
			figureT = figureOne * figureTwo;
			break;
		case "/":
			figureT = figureOne / figureTwo;
			break;
		}
		stack.push(String.valueOf(figureT));
		if(c!="="){
			stack.push(c);
		}

	}

	/**
	 * 判断c优先级是否小于乘除 是返回false，否则true
	 * 
	 * @param c
	 * @return
	 */
	private boolean isMD(char c) {
		
		
		return false;
	}

	private void handleMultiplyAndDivide(String c) {

		String st = stack.pop();
		switch (st) {
		case "+":
			// 再次把+号压入运算符栈中
			stack.push("+");
			break;
		case "-":
			// 再次把-号压入运算符栈中
			stack.push("-");
			break;
		case "*":
			figureOne = Double.valueOf(stack.pop());
			figureTwo = Double.valueOf(stack.pop());
			figureT = figureOne * figureTwo;
			stack.push(Double.toString(figureT));
			// 再把当前读到的运算符压入运算符栈中
			stack.push(c);
			break;
		case "/":
			figureOne = Double.valueOf(stack.pop());
			figureTwo = Double.valueOf(stack.pop());
			figureT = figureTwo / figureOne;
			stack.push(Double.toString(figureT));
			stack.push(c);
		}
	}

	private boolean isNum(String peek) {

		Matcher matcher = patten.matcher(peek);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
