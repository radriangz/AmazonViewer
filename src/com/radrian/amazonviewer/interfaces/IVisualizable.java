package com.radrian.amazonviewer.interfaces;

import java.util.Date;

public interface IVisualizable {
	
	/**
	 * This method captures the visualization's beginning exact time. 
	 * <p>
	 * @param dateI is a {@code Date} object which captures the exact time.
	 * @return dateI the date and time captured.
	 * */
	Date startToWatch(Date dateI);
	
	/**
	 * This method captures the visualization's beginning and ending exact time. 
	 * <p>
	 * @param dateI is a {@code Date} object which captures the beginning exact time.
	 * @param dateF is a {@code Date} object which captures the ending exact time
	 * @return the date and time captured.
	 * */
	void stopWatching(Date dateI, Date dateF);
}
