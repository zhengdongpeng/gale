package 观察者模式.impl;
import 观察者模式.inter.DisplayElement;
import 观察者模式.inter.Observer;
import 观察者模式.inter.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private double temperature;// 温度
	private double humidity;//湿度
	private Subject weatherDate;
	
	public CurrentConditionsDisplay( Subject weatherDate) {
		this.weatherDate=weatherDate;
		weatherDate.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions :"+this.temperature+"F degrees and "
				+this.humidity+"%humidity");
	}

	@Override
	public void update(double... a) {
		this.temperature=a[0];
		this.humidity=a[1];
		display();
	}

	@Override
	public void update(double a, double b, double c) {
		this.temperature=a;
		this.humidity=b;
		display();
		
	}




}
