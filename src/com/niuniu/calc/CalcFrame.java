package com.niuniu.calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.peer.LabelPeer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 计算器的视图（view）
 * 
 * @author LiuMei
 *
 */
public class CalcFrame extends JFrame // implements CalcCallback
{

	
	private static final long serialVersionUID = 5945698939240599924L;
	

	/**
	 * 显示计算结果
	 */
	private JLabel labelresult;

	/**
	 * 按钮上的标签
	 */
	private String[] titles = { "C", "Del", "%", "/", "7", "8", "9", "*", "4",
			"5", "6", "-", "1", "2", "3", "+", "00", "0", ".", "=" };
	/**
	 * 按钮
	 */
	private JButton[] buttons = new JButton[titles.length];

	/**
	 * 监听器
	 */
	private Controller controller;

	/**
	 * 构造方法
	 * 
	 * @param controller
	 */

	public CalcFrame(Controller controller) throws HeadlessException {

		this.controller = controller;

		initUi();
		setVisible(true);
	}

	private void initUi() {

		setTitle("计算机-LM作品");
		setSize(375, 500);
		setResizable(false);// 大小不能变化
		setLocationRelativeTo(null);// 居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 添加结果标签
		labelresult = new JLabel("0.0");

		labelresult.setBorder(new EmptyBorder(30, 10, 20, 10));
		;
		labelresult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelresult.setFont(new Font("微软雅黑", Font.PLAIN, 32));

		add(labelresult, BorderLayout.NORTH);

		// 按钮面板 布局
		JPanel buttJPanel = new JPanel(new GridLayout(5, 4, 5, 5));
		// 面板添加到中间
		add(buttJPanel, BorderLayout.CENTER);

		for (int i = 0; i < titles.length; i++) {

			if (titles.length == 0) {

				// 不显示内容的标签
				// buttJPanel.add(new Label(""));
			} else {

				// 按钮
				buttons[i] = new JButton(titles[i]);
				buttons[i].setBackground(Color.pink);
				// 按钮点击事件的监听器
				buttons[i].addActionListener(controller);
				buttJPanel.add(buttons[i]);
			}
		}

	}

	/**
	 * 设置方法【注入】视图所需的控制器
	 * 
	 * @param controller
	 */
//	public void setController(Controller controller) {
//
//		this.controller = controller;
//	}
}
