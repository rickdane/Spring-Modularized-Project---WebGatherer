package com.rickdane.springmodularizedproject.module.webgatherer.component.threadable;

import org.springframework.beans.factory.annotation.Autowired;

import com.rickdane.springmodularizedproject.module.consumabledata.datarecord.DatarecordController;


public class ScraperThreadManager {


	@Autowired
	DatarecordController datarecordController;

	public void startThread() {

		ScraperThread scraperThread = new ScraperThread(
				datarecordController);
		scraperThread.start();
		System.out.println("webgatherer thread launched");
	}

}
