package com.niuniu.calc;

import java.util.Observable;
import java.util.Stack;

/**
 * 计算器的模型（Model）
 * 
 * 模型中的数据发布出去（）
 * 
 * @author LiuMei
 *
 */
public class CalcModel extends Observable{

	// 逆波兰表达式（后序表达式）
	// 操作数和运算符
	Stack<String> stack;
	
	private String input;
	
	Todo do1;
	

	/**
	 * 计算器
	 */
	public CalcModel() {
		stack = new Stack<String>();
	}

	public void push(String e) {
		stack.push(e);

		System.out.println(stack);
		
		//数据改变了，通知观察者
		setChanged();
		notifyObservers(stack.toString());
	}

	/**
	 * 清空
	 */
	public void clear() {
		stack.clear();
		setChanged();
		notifyObservers(stack.toString());
	}

	/**
	 * 按键点击的结果
	 * 
	 * @return
	 */
	public String result() {
		return stack.toString();
	}

	

	

	@Override
	public String toString() {
		return "CalcModel " + (stack != null ? "stack=" + stack : "");
	}

	public void todo() {
		//运算
		//通知视图更新
		//
		do1 = new Todo(input);
		String result = do1.countExpression();
		
		
		notifyObservers(result);
		
	}

	public void delete() {
		if(!stack.isEmpty()){
			int index = stack.size() - 1;
			stack.remove(index);
			setChanged();
			notifyObservers(stack.toString());
		}
		
	}

	public void setInput(String command) {
		
		input = command;
		System.out.println(input);
		
		setChanged();
		notifyObservers(input);
		
	}

	

}
