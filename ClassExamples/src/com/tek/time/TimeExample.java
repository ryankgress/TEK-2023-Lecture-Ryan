package com.tek.time;


/**
 * Turning an int of seconds into hours/minutes/seconds
 * @author ryank
 *
 */
public class TimeExample {

	public static void main(String[] args) {
		int seconds = 423;
		int hr = 0;
		int min = 0;
		int sec = 0;
		
		sec = seconds % 60;
		hr = seconds / 60;
		min = hr % 60;
		hr = hr / 60;
		
		System.out.println(hr + ":" + min + ":" + sec);
	}

}
