package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.lc.DataCenter.DataCenter;
import com.lc.utils.JustIDEAUtil;

import javax.swing.*;
import java.awt.*;
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

	// 无参构造函数
	public MyHelloWorldDialog() {
		// 直接在内容面板 MyHelloWorldDialogJPanel1 上添加鼠标监听器
		// 在内容面板 MyHelloWorldDialogJPanel1 下的所有区域均可触发
		// 文本域 除外 比如 MyInputTextArea MyShowTextArea 均不可触发的.
		JustIDEAUtil.addMouseListenerForJustIDEA(MyHelloWorldDialogJPanel1);

		// 继续逻辑
		// 设置 ContentPane
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
		String randomString = RandomUtil.randomString(5);
		// 每次将结果 也更新到 数据中心 输出区文本 最新状态的值
		// 用于其他的组件 获取使用
		DataCenter.latestShowJLableText = randomString;
		MyShowTextArea.setText("随机字符串: " + DataCenter.latestShowJLableText);
	}

	private void fastGitButtonHandle(ActionEvent e) {

		Console.log("fastGitButtonHandle...ActionEvent...ID...", e.getID());

		// 获取输入区 输入值
		// 去除空格
		String myInputTextAreaText = MyInputTextArea.getText().trim();

		// 判断输入区是不是空
		if (StrUtil.isEmptyIfStr(myInputTextAreaText)) {
			JustIDEAUtil.showInWarningMessage("输入区不能空(请输入github完成路径, 类似【https://github.com/ahviplc/JustIDEA】)", "警告提示");
			return;
		}
		// 判断是不是 https
		if (!HttpUtil.isHttps(myInputTextAreaText)) {
			JustIDEAUtil.showInWarningMessage("不是https开头的url, 类似的合法输入如下【https://github.com/dromara/hutool】", "警告提示");
			return;
		}

		// 判断是不是 github url
		if (!StrUtil.contains(myInputTextAreaText, "https://github.com")) {
			JustIDEAUtil.showInWarningMessage("不是github合法的url, 类似的合法输入如下【https://github.com/dromara/hutool】", "警告提示");
			return;
		}

		// 不是空的话 校验都通过的话 输出一下
		Console.log("myInputTextAreaText 处理前 => ", myInputTextAreaText);

		// 处理
		// myInputTextAreaText 处理前 =>  https://github.com/dromara/hutool
		// myInputTextAreaText 处理后 =>  https://hub.fastgit.org/dromara/hutool
		myInputTextAreaText = StrUtil.replace(myInputTextAreaText, "github.com", "hub.fastgit.org");

		Console.log("myInputTextAreaText 处理后 => ", myInputTextAreaText);

		// 每次将结果 也更新到 数据中心 输出区文本 最新状态的值
		// 用于其他的组件 获取使用
		DataCenter.latestShowJLableText = myInputTextAreaText;

		// 在输出区 显示最后处理完成的 结果
		MyShowTextArea.setText(DataCenter.latestShowJLableText);
	}

	private void github1sButtonHandle(ActionEvent e) {

		Console.log("github1sButtonHanle...ActionEvent...ID...", e.getID());

		// 获取输入区 输入值
		// 去除空格
		String myInputTextAreaText = MyInputTextArea.getText().trim();

		// 判断输入区是不是空
		if (StrUtil.isEmptyIfStr(myInputTextAreaText)) {
			JustIDEAUtil.showInWarningMessage("输入区不能空(请输入github完成路径, 类似【https://github.com/ahviplc/JustIDEA】)", "警告提示");
			return;
		}

		// 判断是不是 https
		if (!HttpUtil.isHttps(myInputTextAreaText)) {
			JustIDEAUtil.showInWarningMessage("不是https开头的url, 类似的合法输入如下【https://github.com/dromara/hutool】", "警告提示");
			return;
		}

		// 判断是不是 github url
		if (!StrUtil.contains(myInputTextAreaText, "https://github.com")) {
			JustIDEAUtil.showInWarningMessage("不是github合法的url, 类似的合法输入如下【https://github.com/dromara/hutool】", "警告提示");
			return;
		}

		// 不是空的话 校验都通过的话 输出一下
		Console.log("myInputTextAreaText 处理前 => ", myInputTextAreaText);

		// 处理
		// myInputTextAreaText 处理前 =>  https://github.com/dromara/hutool
		// myInputTextAreaText 处理后 =>  https://github1s.com/dromara/hutool
		myInputTextAreaText = StrUtil.replace(myInputTextAreaText, "github.com", "github1s.com");

		Console.log("myInputTextAreaText 处理后 => ", myInputTextAreaText);

		// 每次将结果 也更新到 数据中心 输出区文本 最新状态的值
		// 用于其他的组件 获取使用
		DataCenter.latestShowJLableText = myInputTextAreaText;

		// 在输出区 显示最后处理完成的 结果
		MyShowTextArea.setText(DataCenter.latestShowJLableText);
	}

	// 复制到系统剪贴板 按钮
	private void CopyThatButtonHandle(ActionEvent e) {
		// 每次将结果 也更新到 数据中心 输出区文本 最新状态的值
		// 用于其他的组件 获取使用
		// 将输出区的文本复制 从数据中心 latestShowJLableText 取值
		JustIDEAUtil.setClipboardString(DataCenter.latestShowJLableText);
		Console.log("...复制到系统剪贴板 按钮 被点击...输出当前系统剪切板的值: {} ...", JustIDEAUtil.getClipboardString());
	}
}
