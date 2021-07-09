package com.lc.utils;

import cn.hutool.core.lang.Console;
import cn.hutool.log.StaticLog;
import com.lc.DataCenter.DataCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
 * <p>
 * JavaSwing_4.7: JPopupMenu（弹出菜单）
 * https://blog.csdn.net/xietansheng/article/details/78079800
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

	/**
	 * 直接在组件 jComponent 上添加鼠标监听器
	 *
	 * @param jComponent 在哪个组件上添加鼠标监听器
	 */
	public static void addMouseListenerForJustIDEA(JComponent jComponent) {
		jComponent.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 鼠标点击（按下并抬起）
				Console.log("...mouseClicked 鼠标点击（按下并抬起）...");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 鼠标按下
				Console.log("...mousePressed 鼠标按下...");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// 鼠标释放
				Console.log("...mouseReleased 鼠标释放...");
				// 如果是鼠标右键，则显示弹出菜单 触发右键菜单
				if (e.isMetaDown()) {
					showPopupMenu(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 鼠标进入组件区域
				Console.log("...mouseEntered 鼠标进入组件区域...");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 鼠标离开组件区域
				Console.log("...mouseExited 鼠标离开组件区域...");
			}
		});
	}

	/**
	 * 弹出菜单 弹出式菜单 右键菜单
	 *
	 * @param invoker 弹出菜单将出现在其空间中的组件
	 * @param x       调用者坐标空间中的 x 坐标，弹出菜单将在该坐标空间中显示
	 * @param y       调用者坐标空间中的 y 坐标，弹出菜单将在该坐标空间中显示
	 */
	public static void showPopupMenu(Component invoker, int x, int y) {
		// 创建 弹出菜单 对象
		JPopupMenu popupMenu = new JPopupMenu();
		// 创建 一级菜单
		JMenuItem copyMenuItem = new JMenuItem("复制输出区文本");
		JMenuItem pasteMenuItem = new JMenuItem("粘贴");
		// 需要 添加 二级子菜单 的 菜单，使用 JMenu
		JMenu extMenu = new JMenu("扩展功能");
		// 关于 About
		JMenuItem aboutMenu = new JMenuItem("About");
		// 创建 二级菜单
		JMenuItem weatherItem = new JMenuItem("天气预报");
		JMenuItem ext1MenuItem = new JMenuItem("todo-扩展1");
		JMenuItem ext2MenuItem = new JMenuItem("todo-扩展2");
		// 添加 二级菜单 到 "扩展功能"一级菜单
		extMenu.add(weatherItem);
		extMenu.add(ext1MenuItem);
		extMenu.add(ext2MenuItem);
		// 添加 一级菜单 到 弹出菜单
		popupMenu.add(copyMenuItem);
		popupMenu.add(pasteMenuItem);
		// 添加一条分隔符
		popupMenu.addSeparator();
		// 添加 一级菜单 到 弹出菜单
		popupMenu.add(extMenu);
		popupMenu.add(aboutMenu);

		// 添加菜单项的点击监听器
		copyMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JustIDEAUtil.setClipboardString(DataCenter.latestShowJLableText);
				Console.log("...复制输出区文本 被点击...输出当前系统剪切板的值: {} ...", JustIDEAUtil.getClipboardString());
			}
		});
		pasteMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.log("...粘贴 被点击...输出当前系统剪切板的值: {} ...", JustIDEAUtil.getClipboardString());
			}
		});

		weatherItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.log("...天气预报 被点击...");
			}
		});
		ext1MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.log("...todo-扩展1 被点击...");
			}
		});
		ext2MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.log("...todo-扩展2 被点击...");
			}
		});

		aboutMenu.addActionListener(e -> {
			Console.log("...About 被点击...");
			showInformationMessage(DataCenter.About, "About 关于我");
		});

		// ......
		// 在指定位置显示弹出菜单
		popupMenu.show(invoker, x, y);
	}

	public static void main(String[] args) {
		StaticLog.info("getClipboardString info => {}", "just test");
		showInErrorMessage("test error", "error");
	}
}


