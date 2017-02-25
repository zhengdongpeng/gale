package 策略模式.impl;

import 策略模式.inter.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("fei ya fei ya fei!!");
	}

}
