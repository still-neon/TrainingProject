package by.stn.java_exercises.modul_1.ex_24_need_fix.video_devices;

import lombok.Getter;

public class Camera /*extends AbstractVideoElectronicDevice */{
	@Getter
	private String batteryType;

	public Camera(int power, String manufacturer, String color, boolean turnedOn, int displaySize, int contrastLevel, String batteryType) {
		//super(power, manufacturer, color, turnedOn, displaySize, contrastLevel);
		this.batteryType = batteryType;
	}
/*
	public void turnOn() {
		setTurnedOn(true);
	}

	public void turnOff() {
		setTurnedOn(false);
	}

	public void increaseContrast() {
		setContrastLevel(getContrastLevel()+1);
	}

	public void decreaseContrast() {
		setContrastLevel(getContrastLevel()-1);
	}*/
}