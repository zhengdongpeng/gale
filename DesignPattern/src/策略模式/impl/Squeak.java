package 策略模式.impl;

import 策略模式.inter.QuackBehavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("唧唧叫");
	}

}
