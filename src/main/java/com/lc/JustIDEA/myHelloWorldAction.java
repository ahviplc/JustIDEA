package com.lc.JustIDEA;

import cn.hutool.core.lang.Console;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;

// import java.awt.*;

public class myHelloWorldAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {
		Console.log("You in | ", "com.lc.JustIDEA.myHelloWorldAction.actionPerformed line:10");
		// Console.log("You in e| ", e);
		JBPopup popup = JBPopupFactory.getInstance().createMessage("这是一个最简单的HelloWorld提示框.");
		popup.showInBestPositionFor(e.getDataContext());

		MyHelloWorldDialog myDialog = new MyHelloWorldDialog();
		myDialog.setTitle("JustIDEA-MyHelloWorldDialog");
		// 居中
		myDialog.setLocationRelativeTo(myDialog);
		myDialog.pack();
		myDialog.setVisible(true);
	}
}
