package by.stn.java_exercises.modul_1.ex_24_need_fix.audio_devices;

import lombok.Getter;

public class Dynamics extends AbstractAudioDevice {
	@Getter
	private String corpusMaterial;

	public Dynamics(int power, String manufacturer, String color, boolean turnedOn, int sensitivity, int volumeLevel, String corpusMaterial) {
		super(power, manufacturer, color, turnedOn, sensitivity, volumeLevel);
		this.corpusMaterial = corpusMaterial;
	}

	public void turnOn() {
		setTurnedOn(true);
	}

	public void turnOff() {
		setTurnedOn(false);
	}

	public void increaseVolume() {
		setVolumeLevel(getVolumeLevel()+1);
	}

	public void decreaseVolume() {
		setVolumeLevel(getVolumeLevel()-1);
	}
}