package com.niuniu.calc;

public class App {

	public static void main(String[] args) {

		// 调整代码结构【重构】
		// 模型
		CalcModel model = new CalcModel();

		// 控制器
		Controller controller = new Controller();
		controller.setModel(model);

		// 视图
		CalcFrame view = new CalcFrame(controller);

		// 装配 （依赖关系）
		// 解决组件之间的依赖问题： 1）构造方法注入 2）setter方法注入依赖的组件
		// controller.setModel(model);
		// view.setController(controller);
	}

}
