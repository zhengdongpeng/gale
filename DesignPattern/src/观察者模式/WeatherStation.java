package 观察者模式;

import 观察者模式.impl.CurrentConditionsDisplay;
import 观察者模式.impl.WeatherDate;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherDate weatherDate=new WeatherDate();
		CurrentConditionsDisplay ccd=new CurrentConditionsDisplay(weatherDate);
		CurrentConditionsDisplay dd=new CurrentConditionsDisplay(weatherDate);
		CurrentConditionsDisplay xx=new CurrentConditionsDisplay(weatherDate);
		weatherDate.setMeasurements(80,65,25);
		weatherDate.setMeasurements(56,54,23);
		weatherDate.setMeasurements(89,41,17);
	}

}
