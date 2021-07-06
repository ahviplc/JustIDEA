package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.lc.DataCenter.DataCenter;

// import java.awt.*;

/**
 * myHelloWorldAction 此为入口
 *
 * <p>
 * 触发方式:
 * Ctrl+Alt+Shift+R 为此 IDEA 插件的快捷键 使用可触发此插件.
 * 或者 点击 IDEA 上面的菜单栏的 Tools 打开菜单之后 基本在第一个有个叫 JustIDEA-HelloWorld 选项,点击即可使用.
 * <p>
 */
public class myHelloWorldAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {
		Console.log("You in | ", "com.lc.JustIDEA.myHelloWorldAction.actionPerformed line:24");
		// Console.log("You in e| ", e);
		// 弹出提示框
		// JBPopup popup = JBPopupFactory.getInstance().createMessage("这是一个最简单的HelloWorld提示框.");
		// popup.showInBestPositionFor(e.getDataContext());

		// 开始逻辑
		// DataCenter maxim 箴言赋值
		DataCenter.maxim = "同意吗？一人一世界,一树一菩提！~LC";

		MyHelloWorldDialog myDialog = new MyHelloWorldDialog();
		// myDialog.setTitle("JustIDEA-MyHelloWorldDialog");
		myDialog.setTitle("JustIDEA - one IDEA plugin ❤ for you ❤");
		// 居中
		myDialog.setLocationRelativeTo(myDialog);
		myDialog.pack();
		myDialog.setVisible(true);
	}
}
