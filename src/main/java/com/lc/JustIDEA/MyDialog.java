package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyDialog extends JDialog {
	// 整个窗口框体内容
	private JPanel contentPane;
	// OK 按钮
	private JButton buttonOK;
	// Cancel 按钮
	private JButton buttonCancel;
	private JPanel MyDialogJPanel1;
	private JPanel MyDialogJPanel2;
	// 名言载体
	private JLabel MyDialogText1;

	public MyDialog() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);
		// 设置主面板的大小 300,250
		setPreferredSize(new Dimension(300, 250));

		// JLabel 设置字体 宋体 这个宋体 中文才不乱码
		MyDialogText1.setFont(new Font("MS Song", Font.PLAIN, 12));
		// 名言赋值
		MyDialogText1.setText("同意吗？一人一世界,一树一菩提！~LC");

		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});

		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}

	private void onOK() {
		// add your code here
		Console.log("onOK...", MyDialogText1.getText());
		dispose();
	}

	private void onCancel() {
		// add your code here if necessary
		Console.log("onCancel...", MyDialogText1.getText());
		dispose();
	}

	public static void main(String[] args) {
		MyDialog dialog = new MyDialog();
		// 运行窗口 MyDialog
		dialog.setTitle("JustIDEA-MyDialog-名言说");
		// 居中
		dialog.setLocationRelativeTo(dialog);
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}
}
