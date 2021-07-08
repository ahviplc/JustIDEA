package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyHelloWorldDialog extends JDialog {
	// 整个窗口框体内容
	private JPanel MyHelloWorldDialogJPanel1;
	// JustIDEA 的 JLabel标签
	private JLabel JustIDEAJLable;
	// 点我跳 按钮
	private JButton ReadMaximButton;
	// 输出区
	// 输出标签 输出文本域
	private JLabel MyShowJLable;
	private JTextArea MyShowTextArea;
	// 输入区
	// 输入标签 输出入本域
	private JLabel MyInputJLable;
	private JTextArea MyInputTextArea;
	// 随机字符串 按钮
	private JButton RandomStrButton;
	// fastgit 按钮
	private JButton FastGitButton;
	// github1s 按钮
	private JButton Github1sButton;
	private JButton CopyThatButton;

	public MyHelloWorldDialog() {
		setContentPane(MyHelloWorldDialogJPanel1);
		setModal(true);
		getRootPane().setDefaultButton(ReadMaximButton);
		// 得到屏幕的尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Console.log("screenSize", screenSize.width, screenSize.height);
		// 设置主面板的大小 700,500
		setPreferredSize(new Dimension(700, 500));

		// JTextArea 设置字体 宋体
		MyShowTextArea.setFont(new Font("MS Song", Font.PLAIN, 14));

		ReadMaximButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReadMaximButtonHandle();
			}
		});

		RandomStrButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RandomStrButtonHandle();
			}
		});

		FastGitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fastGitButtonHandle(e);
			}
		});

		Github1sButton.addActionListener(e -> {
			github1sButtonHandle(e);
		});

		CopyThatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CopyThatButtonHandle(e);
			}
		});

		// pass
	}

	// 跳转按钮 Handle
	// 跳转新窗口 MyDialog 箴言说
	public void ReadMaximButtonHandle() {
		Console.log("...ReadMaximButtonHandle...");
		// 跳转新窗口 MyDialog 箴言说
		MyDialog dialog = new MyDialog();
		// dialog.setTitle("JustIDEA-MyDialog-箴言说");
		dialog.setTitle("JustIDEA-箴言说");
		// 居中
		dialog.setLocationRelativeTo(dialog);
		dialog.pack();
		dialog.setVisible(true);
	}

	// 随机字符串按钮 Handle
	public void RandomStrButtonHandle() {
		Console.log("...RandomStrButtonHandle...");
		MyShowTextArea.setText("随机字符串: " + RandomUtil.randomString(5));
	}

	private void fastGitButtonHandle(ActionEvent e) {

		Console.log("fastGitButtonHandle...ActionEvent...ID...", e.getID());

		// 获取输入区 输入值
		// 去除空格
		String myInputTextAreaText = MyInputTextArea.getText().trim();

		// 判断输入区是不是空
		if (StrUtil.isEmptyIfStr(myInputTextAreaText)) {
			JOptionPane.showMessageDialog(null, "输入区不能空(请输入github完成路径,类似【https://github.com/ahviplc/JustIDEA】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// 判断是不是 https
		if (!HttpUtil.isHttps(myInputTextAreaText)) {
			JOptionPane.showMessageDialog(null, "不是https开头的url,类似的合法输入如下【https://github.com/dromara/hutool】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 判断是不是 github url
		if (!StrUtil.contains(myInputTextAreaText, "https://github.com")) {
			JOptionPane.showMessageDialog(null, "不是github合法的url,类似的合法输入如下【https://github.com/dromara/hutool】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 不是空的话 校验都通过的话 输出一下
		Console.log("myInputTextAreaText 处理前 => ", myInputTextAreaText);

		// 处理
		// myInputTextAreaText 处理前 =>  https://github.com/dromara/hutool
		// myInputTextAreaText 处理后 =>  https://hub.fastgit.org/dromara/hutool
		myInputTextAreaText = StrUtil.replace(myInputTextAreaText, "github.com", "hub.fastgit.org");

		Console.log("myInputTextAreaText 处理后 => ", myInputTextAreaText);

		// 在输出区 显示最后处理完成的 结果
		MyShowTextArea.setText(myInputTextAreaText);
	}

	private void github1sButtonHandle(ActionEvent e) {

		Console.log("github1sButtonHanle...ActionEvent...ID...", e.getID());

		// 获取输入区 输入值
		// 去除空格
		String myInputTextAreaText = MyInputTextArea.getText().trim();

		// 判断输入区是不是空
		if (StrUtil.isEmptyIfStr(myInputTextAreaText)) {
			JOptionPane.showMessageDialog(null, "输入区不能空(请输入github完成路径,类似【https://github.com/ahviplc/JustIDEA】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 判断是不是 https
		if (!HttpUtil.isHttps(myInputTextAreaText)) {
			JOptionPane.showMessageDialog(null, "不是https开头的url,类似的合法输入如下【https://github.com/dromara/hutool】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 判断是不是 github url
		if (!StrUtil.contains(myInputTextAreaText, "https://github.com")) {
			JOptionPane.showMessageDialog(null, "不是github合法的url,类似的合法输入如下【https://github.com/dromara/hutool】)", "警告提示", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 不是空的话 校验都通过的话 输出一下
		Console.log("myInputTextAreaText 处理前 => ", myInputTextAreaText);

		// 处理
		// myInputTextAreaText 处理前 =>  https://github.com/dromara/hutool
		// myInputTextAreaText 处理后 =>  https://github1s.com/dromara/hutool
		myInputTextAreaText = StrUtil.replace(myInputTextAreaText, "github.com", "github1s.com");

		Console.log("myInputTextAreaText 处理后 => ", myInputTextAreaText);

		// 在输出区 显示最后处理完成的 结果
		MyShowTextArea.setText(myInputTextAreaText);
	}

	// 复制到系统剪贴板 按钮
	private void CopyThatButtonHandle(ActionEvent e) {
		// 将输出区的文本复制
		StringSelection myShowTextAreaSelection = new StringSelection(MyShowTextArea.getText());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(myShowTextAreaSelection, myShowTextAreaSelection);
	}
}
