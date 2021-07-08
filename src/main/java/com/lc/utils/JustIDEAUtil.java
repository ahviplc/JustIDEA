package com.lc.utils;

import cn.hutool.log.StaticLog;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * JustIDEAUtil 工具类
 * 封装了一些java swing的操作方法
 * <p>
 * 666 - Java Swing 图形界面开发（目录）
 * https://blog.csdn.net/xietansheng/article/details/72814492
 * <p>
 * Java操作系统剪贴板(Clipboard)实现复制和粘贴
 * https://blog.csdn.net/xietansheng/article/details/70478266
 * <p>
 * JavaSwing_4.2: JDialog、JOptionPane（对话框）
 * https://blog.csdn.net/xietansheng/article/details/75948933
 */
public class JustIDEAUtil {

	/**
	 * 把文本设置到剪贴板（复制）
	 *
	 * @param text 复制到系统剪切板的文本
	 */
	public static void setClipboardString(String text) {
		// 获取系统剪贴板
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 封装文本内容
		Transferable trans = new StringSelection(text);
		// 把文本内容设置到系统剪贴板
		clipboard.setContents(trans, null);
	}

	/**
	 * 从剪贴板中获取文本（粘贴）
	 *
	 * @return 从系统剪切板获取到的文本
	 */
	public static String getClipboardString() {
		// 获取系统剪贴板
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 获取剪贴板中的内容
		Transferable trans = clipboard.getContents(null);
		if (trans != null) {
			// 判断剪贴板中的内容是否支持文本
			if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					// 获取剪贴板中的文本内容
					String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
					return text;
				} catch (Exception e) {
					// e.printStackTrace();
					StaticLog.error("getClipboardString error => {}", e);
				}
			}
		}
		return null;
	}

	/**
	 * 消息对话框（信息消息）
	 *
	 * @param message 消息内容
	 * @param title   消息标题
	 */
	public static void showInformationMessage(Object message, String title) {
		// 消息对话框无返回, 仅做通知作用
		JOptionPane.showMessageDialog(
				null,
				message,
				title,
				JOptionPane.INFORMATION_MESSAGE
		);
	}

	/**
	 * 消息对话框（警告消息）
	 *
	 * @param message 消息内容
	 * @param title   消息标题
	 */
	public static void showInWarningMessage(Object message, String title) {
		// 消息对话框无返回, 仅做通知作用
		JOptionPane.showMessageDialog(
				null,
				message,
				title,
				JOptionPane.WARNING_MESSAGE
		);
	}

	/**
	 * 消息对话框（错误消息）
	 *
	 * @param message 消息内容
	 * @param title   消息标题
	 */
	public static void showInErrorMessage(Object message, String title) {
		// 消息对话框无返回, 仅做通知作用
		JOptionPane.showMessageDialog(
				null,
				message,
				title,
				JOptionPane.ERROR_MESSAGE
		);
	}

	public static void main(String[] args) {
		StaticLog.info("getClipboardString info => {}", "just test");
		showInErrorMessage("test error", "error");
	}
}


