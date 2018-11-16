package com.radrian.amazonviewer.interfaces;

import java.util.Date;

public interface IVisualizable {
	Date startToWatch(Date dateI);
	
	void stopWatching(Date dateI, Date dateF);
}
