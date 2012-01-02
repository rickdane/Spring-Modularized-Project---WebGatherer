package com.rickdane.springmodularizedproject.module.webgatherer.component.threadable;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.service.DatarecordService;

import org.Webgatherer.ExperimentalLabs.Scraper.Core.ScraperBase;
import org.Webgatherer.Api.Scraper.ScraperFactory;

import java.util.List;

/**
 * @author Rick Dane
 */
public class ScraperThread {

	private DatarecordService datarecordService;

	public ScraperThread(DatarecordService datarecordService) {
		this.datarecordService = datarecordService;
	}

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
