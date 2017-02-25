package 策略模式.impl;

import 策略模式.inter.QuackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("gugugugugu");
	}

}
