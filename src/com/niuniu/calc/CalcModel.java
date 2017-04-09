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
//	Stack<String> stack;
	
	StringBuilder sb;
	
	private String input;
	
	Todo2 do1;
	

	/**
	 * 计算器
	 */
	public CalcModel() {
//		stack = new Stack<String>();
		sb = new StringBuilder();
	}

	public void push(String e) {
//		stack.push(e);
		sb.append(e);

		System.out.println(sb.toString());
		
		//数据改变了，通知观察者
		setChanged();
		notifyObservers(sb.toString());
	}

	/**
	 * 清空
	 */
	public void clear() {
//		stack.clear();
		sb.setLength(0);
		setChanged();
		notifyObservers(sb.toString());
	}

	/**
	 * 按键点击的结果
	 * 
	 * @return
	 */
	public String result() {
		return sb.toString();
	}

	public void todo() {
		//运算
		//通知视图更新
		//
		System.out.println(sb.toString());
		do1 = new Todo2(sb.toString());
		String result = do1.countExpression();
		
		setChanged();
		notifyObservers(result);
		sb.setLength(0);
	}

	public void delete() {
//		if(!stack.isEmpty()){
//			int index = stack.size() - 1;
//			stack.remove(index);
//			setChanged();
//			notifyObservers(stack.toString());
//		}
		if (!(sb.length()==0)) {
			int index = sb.length()-1;
			sb.deleteCharAt(index);
			setChanged();
			notifyObservers(sb.toString());
		}
		
	}

//	public void setInput(String command) {
//		
//		input = command;
//		System.out.println(input);
//		
//		setChanged();
//		notifyObservers(input);
//		
//	}

	

}
