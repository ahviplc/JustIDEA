package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyHelloWorldDialog extends JDialog {
	// 整个窗口框体内容
	private JPanel MyHelloWorldDialogJPanel1;
	private JLabel JustIDEA;
	// 点我跳 按钮
	private JButton DianWoButton;
	// 文本域
	private JTextArea MytextArea;
	// 点我入文本 按钮
	private JButton DianWoTextButton;

	public MyHelloWorldDialog() {
		setContentPane(MyHelloWorldDialogJPanel1);
		setModal(true);
		getRootPane().setDefaultButton(DianWoButton);
		// 得到屏幕的尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Console.log("screenSize", screenSize.width, screenSize.height);
		// 设置主面板的大小 700,500
		setPreferredSize(new Dimension(700, 500));

		// JTextArea 设置字体 宋体
		MytextArea.setFont(new Font("MS Song", Font.PLAIN, 14));

		DianWoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DianWoButtonHandle();
			}
		});

		DianWoTextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DianWoTextButtonHandle();
			}
		});
	}

	public void DianWoButtonHandle() {
		Console.log("DianWoButtonHandle...");
		// 跳转新窗口 MyDialog
		MyDialog dialog = new MyDialog();
		dialog.setTitle("JustIDEA-MyDialog-名言说");
		// 居中
		dialog.setLocationRelativeTo(dialog);
		dialog.pack();
		dialog.setVisible(true);
	}

	public void DianWoTextButtonHandle() {
		Console.log("DianWoTextButtonHandle...");
		MytextArea.setText("DianWoTextButtonHandle" + RandomUtil.randomString(5));
	}
}
