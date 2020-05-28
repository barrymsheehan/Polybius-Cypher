package com.barrysheehan.www;

/*
 * The Timer class uses the System.nanoTime() method to capture the time.
 * The start() and stop methods are simply calls to System.nanoTime() which store the returned value
 * in instance variables startTime and endTime.
 */

public class Timer {
	private long startTime;
	private long endTime;
	
	public void start() {
		this.startTime = System.nanoTime();
	}
	
	public void stop() {
		this.endTime = System.nanoTime();
	}
	
	/*
	 * Divide by 1000000 to get time in milliseconds rather than nanoseconds
	 */
	public long calculateTime() {
		long executionTime = (endTime - startTime) / 1000000;
		return executionTime;
	}
	
}
