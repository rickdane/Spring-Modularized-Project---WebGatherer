package com.rickdane.springmodularizedproject.module.webgatherer.component.threadable;

import java.util.List;

import org.Webgatherer.Api.Scraper.ScraperFactory;
import org.Webgatherer.ExperimentalLabs.Scraper.Core.ScraperBase;
import org.springframework.beans.factory.annotation.Autowired;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.service.DatarecordService;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import com.rickdane.springmodularizedproject.module.webgatherer.service.ScraperService;

public class ScraperThread extends Thread {
	
	@Autowired
    DatarecordService datarecordService;

	public void run() {
		int pageNum = 1;
		int maxPages = 2;

		ScraperBase scraper = ScraperFactory.createScraper("generic");

		List<String[]> urlEntries = scraper.run("java", pageNum, maxPages);

		// demonstration of persisting to web service
		for (String[] curEntry : urlEntries) {
			Datarecord datarecord = new Datarecord();
			datarecord.setEntry(curEntry[1]);
			datarecordService.saveDatarecord(datarecord);
			
		}
	}

}
