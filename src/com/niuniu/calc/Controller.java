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

	private StringBuilder input = new StringBuilder();

	

	public Controller() {
		super();
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
			model.todo();
			// callback.showResult();
			break;
		default:
			input.append(command);
//			model.push(input.toString());
//			input.delete(0, input.length());
		}
		

//		callback.showInput();

	}

	/**
	 *设置控制器依赖的模式
	 * @param model
	 */
	public void setModel(CalcModel model) {

		this.model = model;
	}

}
