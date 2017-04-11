package com.niuniu.calc;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Todo2 {

	Stack<String> stack;

	// 表达式字符串
	String expression = null;

	private Pattern patten = Pattern.compile("\\d\\.?\\d?");

	// 操作数一
	double figureOne = 0;
	// 操作数二
	double figureTwo = 0;
	// 两操作数结果
	double figureT = 0;
	// 一个随机当做参数的字符
	char randomChar;

//	StringBuilder sb = new StringBuilder();

	public Todo2(String expression) {

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
		String st = null;

		// System.out.println(expression);
		int n = expression.length();
		while (currentIndex <= n - 1) {

			currentChar = expression.charAt(currentIndex);
			// 如果是数字
			if (Character.isDigit(currentChar) || currentChar == '.') {
				currentIndex++;
				//
				while (currentIndex <= n - 1
						&& (Character.isDigit(expression.charAt(currentIndex)) || expression
								.charAt(currentIndex) == '.')) {
					currentIndex++;
				}
				st = expression.substring(lastIndex, currentIndex);
				// System.out.println(st);
				lastIndex = currentIndex;
				if (stack.isEmpty() || isNum(stack.peek())) {
					//如果为空栈，直接存数字
					stack.push(st);
				} else {
					//取出符号
					String st2 = stack.pop(); //
					if(stack.size()==1){
						//栈顶是数字
						stack.push(st); 
						stack.push(st2);
					}else{
						//栈顶还是符号
						String st3 = stack.pop();
						stack.push(st);
						stack.push(st3);
						handleMultiplyAndDivide(st2);
//						stack.push(st2);
					}
				}
//				sb.append(st);
			} else {
				// 如果是字符

				// 判断栈顶符号
				switch (currentChar) {
				case '+':
					if (isNum(stack.peek())) {
						// 栈顶为数字时
						st = String.valueOf(currentChar);
						stack.push(st);
//						sb.append(st);
					} else {
						handleAddAndSubtract("+");
					}
					break;
				case '-':
					if (isNum(stack.peek())) {
						// 栈顶为数字时
						st = String.valueOf(currentChar);
						stack.push(st);
//						sb.append(st);
					} else {
						handleAddAndSubtract("-");
					}
					break;
				case '*':
					if (isNum(stack.peek())) {
						// 栈顶为数字时
						st = String.valueOf(currentChar);
						stack.push(st);
//						sb.append(st);
					} else {
						handleMultiplyAndDivide("*");
					}

					break;
				case '/':
					if (isNum(stack.peek())) {
						// 栈顶为数字时
						st = String.valueOf(currentChar);
						stack.push(st);
//						sb.append(st);
					} else {
						handleMultiplyAndDivide("/");
					}
					break;
				case '%':
					break;
				}
				currentIndex++;
				lastIndex = currentIndex;
			}

		}

		theOtherWayCount();
		result = stack.peek();
//		System.out.println(sb.toString());
		System.out.println(result);
		return result;
	}

	/**
	 * 
	 * @param st
	 */
	private void handleMultiplyAndDivide(String st) {

		String st2 = stack.pop();
		switch (st2) {
		case "+":
			stack.push(st);
			stack.push(st2);
			break;
		case "-":
			stack.push(st);
			stack.push(st2);
			break;
		case "*":
			figureOne = Double.valueOf(stack.pop());
			figureTwo = Double.valueOf(stack.pop());
			figureT = figureOne * figureTwo;
			stack.push(String.valueOf(figureT));
			stack.push(st);
//			sb.append(st);
			break;
		case "/":
			figureOne = Double.valueOf(stack.pop());
			figureTwo = Double.valueOf(stack.pop());
			figureT = figureTwo / figureOne;
			System.out.println(figureT);
			stack.push(String.valueOf(figureT));
			stack.push(st);
//			sb.append(st);
			break;
		}
	}

	/**
	 * 
	 * @param st
	 *            传来的参数st为加或者减，优先级较低
	 */
	private void handleAddAndSubtract(String st) {

		String st2 = stack.pop();
		figureOne = Double.valueOf(stack.pop());
		figureTwo = Double.valueOf(stack.pop());
		switch (st2) {
		case "+":
			figureT = figureOne + figureTwo;
			break;
		case "-":
			figureT = figureTwo - figureOne;
			break;
		case "*":
			figureT = figureOne * figureTwo;
			break;
		case "/":
			figureT = figureTwo / figureOne;
			break;
		}
		stack.push(String.valueOf(figureT));
		stack.push(st);

	}

	/**
	 * 进行最后的计算
	 */
	private void theOtherWayCount() {
		while(!stack.isEmpty()){
			System.err.println(stack.pop());
		}
		String st = stack.pop();
		figureOne = Double.valueOf(stack.pop());
		figureTwo = Double.valueOf(stack.pop());
		switch (st) {
		case "+":
			figureT = figureOne + figureTwo;
			break;
		case "-":
			figureT = figureTwo - figureOne;
			break;
		case "*":
			figureT = figureOne * figureTwo;
			break;
		case "/":
			figureT = figureTwo / figureOne;
			System.out.println(figureT);
			break;
		}
		stack.push(String.valueOf(figureT));

	}

	/**
	 * 判断是否为数字
	 * 
	 * @param peek
	 * @return 数字返回true
	 */
	private boolean isNum(String peek) {
		Matcher matcher = patten.matcher(peek);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
