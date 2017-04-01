package com.niuniu.calc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.peer.LabelPeer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 计算器窗口
 * @author LiuMei
 *
 */
public class CalcFrame extends JFrame{

	
	/**
	 * 显示计算结果
	 */
	private JLabel labelresult;
	
	/**
	 * 按钮上的标签
	 */
	private String[] titles = {"C","Del","%","/","7","8","9","*","4","5","6","-",
			"1","2","3","+","00","0",".","="};
	/**
	 * 按钮
	 */
	private JButton[] buttons = new JButton[titles.length];
	
	/**
	 * 构造方法
	 */
	public CalcFrame() {
		initUi();
		setVisible(true);
	}

	private void initUi() {

		setTitle("计算机-LM作品");
		setSize(375,500);
		setResizable(false);//大小不能变化
		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//添加结果标签
		labelresult = new JLabel("0.0");
		
		labelresult.setBorder(new EmptyBorder(30,10,20,10));;
		labelresult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelresult.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		
		add(labelresult,BorderLayout.NORTH);
		
		//按钮面板                                                     布局
		JPanel buttJPanel = new JPanel(new GridLayout(5,4,5,5));
		//面板添加到中间
		add(buttJPanel, BorderLayout.CENTER);
		
		for(int i = 0;i<titles.length;i++){
			
			if(titles.length==0){
				
//			不显示内容的标签
//			buttJPanel.add(new Label(""));
			}else{
				
				//按钮
				buttons[i] = new JButton(titles[i]);
				
				buttJPanel.add(buttons[i]);
			}
		}
		
	}
}
