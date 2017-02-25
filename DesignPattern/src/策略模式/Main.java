package 策略模式;

import 策略模式.impl.FlyNoWay;
import 策略模式.impl.Quack;

public class Main {

	public static void main(String[] args) {
		Duck duck=new MallardDuck();
		duck.setFlyBehavior(new FlyNoWay());
		duck.setQuackBehavior(new Quack());
		duck.performFly();
		duck.performQuack();
		duck.display(new Duck(){
			@Override
			public void display(Duck duck) {
				System.out.println("i am  a real mallard duck"+duck.getClass());
			}
			
		});
	}

}
