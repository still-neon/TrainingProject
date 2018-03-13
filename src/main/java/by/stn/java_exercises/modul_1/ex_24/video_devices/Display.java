package by.stn.java_exercises.modul_1.ex_24.video_devices;

import lombok.Getter;

public class Display extends AbstractVideoDevice {
	@Getter
	private int refreshRate;

	public Display(int power, String manufacturer, String color, boolean turnedOn, int displaySize, int contrastLevel, int refreshRate) {
		super(power, manufacturer, color, turnedOn, displaySize, contrastLevel);
		this.refreshRate = refreshRate;
	}

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
	}
}