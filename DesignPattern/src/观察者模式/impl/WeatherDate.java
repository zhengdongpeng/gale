package 观察者模式.impl;

import java.util.ArrayList;

import 观察者模式.inter.Observer;
import 观察者模式.inter.Subject;

public class WeatherDate implements Subject {

	private ArrayList<Observer> listObserver;//将观察者放入数组中
	private double temperature;// 温度
	private double humidity;//湿度
	private double pressure;//气压
	private Observer observer;
	public WeatherDate() {
		listObserver=new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		listObserver.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i=listObserver.indexOf(o);
		if(i>=0){
			listObserver.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		for(Observer o:listObserver){
			o.update(temperature,humidity,pressure);;
		}
	}
	
	public void measurementsChanged(){
		notifyObserver();
	}
	
	public void setMeasurements(double ...a){
		this.temperature=a[0];
		this.humidity=a[1];
		this.pressure=a[2];
		//measurementsChanged();
		notifyObserver();
	}

}
