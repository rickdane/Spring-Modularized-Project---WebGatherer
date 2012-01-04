package com.rickdane.springmodularizedproject.module.webgatherer.component.threadable;

import org.springframework.beans.factory.annotation.Autowired;
import com.rickdane.springmodularizedproject.module.consumabledata.service.DatarecordService;
import com.rickdane.springmodularizedproject.module.consumabledata.web.DatarecordController;

public class ScraperThreadManager {

	@Autowired
	DatarecordService datarecordService;

	@Autowired
	DatarecordController datarecordController;

	public void startThread() {

		ScraperThread scraperThread = new ScraperThread(datarecordService,
				datarecordController);
		scraperThread.start();
		System.out.println("webgatherer thread launched");
	}

}
