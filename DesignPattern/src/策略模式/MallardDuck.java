package 策略模式;

import 策略模式.impl.FlyWithWings;
import 策略模式.impl.Quack;

public class MallardDuck extends Duck {
	//我是一只真正的野鸭
	@Override
	public void display(Duck duck) {
		duck.display(duck);
	}
	public MallardDuck() {
//		quackBehavior=new Quack();
//		flyBehavior=new FlyWithWings();
	}
}
