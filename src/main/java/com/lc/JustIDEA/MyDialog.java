package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import com.lc.DataCenter.DataCenter;
import com.lc.utils.JinRiShiCiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import cn.hutool.core.util.RandomUtil;

public class MyDialog extends JDialog {
	// 整个窗口框体内容
	private JPanel contentPane;
	// OK 按钮
	private JButton buttonOK;
	// Cancel 按钮
	private JButton buttonCancel;
	// 箴言载体 展示区
	private JLabel MyDialogText1;
	// 换箴言 按钮
	private JButton buttonChangeOne;
	// 未操作
	private JPanel MyDialogJPanel1;
	private JPanel MyDialogJPanel2;

	public MyDialog() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);
		// 设置主面板的大小 300,250
		setPreferredSize(new Dimension(300, 250));

		// JLabel 设置字体 宋体 这个宋体 中文才不乱码
		MyDialogText1.setFont(new Font("MS Song", Font.PLAIN, 12));
		// 箴言 赋值给 展示区
		MyDialogText1.setText(DataCenter.maxim);

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

		// 换箴言 按钮 监听事件
		buttonChangeOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onChangeOne(e);
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

	// 换箴言 监听事件 调用方法
	private void onChangeOne(ActionEvent e) {
		// DataCenter maxim 箴言赋值 重新赋值即可改变
		// 获取 箴言 今日诗词
		String onePoem = JinRiShiCiUtil.getOne();
		// 如果为空
		if (StrUtil.isEmptyIfStr(onePoem)) {
			DataCenter.maxim = "箴言接口api,调用失败";
		} else {
			// 不为空 则是调用成功
			DataCenter.maxim = onePoem;
		}
		Console.log("onChangeOne...ActionEvent...ID...onPoem...", e.getID(), onePoem);
		// 箴言 重新赋值给 展示区
		MyDialogText1.setText(DataCenter.maxim);
	}

	public static void main(String[] args) {
		MyDialog dialog = new MyDialog();
		// 运行窗口 MyDialog
		dialog.setTitle("JustIDEA-MyDialog-箴言说");
		// 居中
		dialog.setLocationRelativeTo(dialog);
		dialog.pack();
		// Shows or hides this Dialog depending on the value of parameter true | false.
		// 显示或隐藏此对话框
		dialog.setVisible(true);
		System.exit(0);
	}
}
