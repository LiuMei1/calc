package com.niuniu.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 按钮的点击事件监听器
 * 
 * @author LiuMei
 *
 */
public class Controller implements ActionListener {

	/**
	 * 计算器的核心
	 */
	private CalcModel model;

	private CalcCallback callback;

	private StringBuilder input = new StringBuilder();

	public Controller(CalcModel calc, CalcCallback callback) {
		super();
		this.model = calc;
		this.callback = callback;
	}

	public Controller() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		// System.out.println(command);

		switch (command) {
		case "%":
		case "+":
		case "-":
		case "*":
		case "/":
			model.push(input.toString());
			input.delete(0, input.length());
			model.push(command);
			break;
		case "Del":
			break;
		case "C":
			model.clear();
			break;
		case "=":
			// callback.showResult();
			break;
		default:
			input.append(command);
		}

//		callback.showInput();

	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(CalcModel model) {

		this.model = model;
	}

}
