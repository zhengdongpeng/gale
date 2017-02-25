package 策略模式;

import 策略模式.inter.FlyBehavior;
import 策略模式.inter.QuackBehavior;

public abstract  class Duck {
	
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public abstract void display(Duck duck);
	
	public void swim(){
		System.out.println("all ducks float,even decoys");
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	
	
	

}
