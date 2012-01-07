package com.rickdane.springmodularizedproject.module.webgatherer.component.threadable;

import com.google.gson.Gson;
import com.rickdane.springmodularizedproject.module.consumabledata.datarecord.DatarecordController;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;


import org.Webgatherer.ExperimentalLabs.Scraper.Core.ScraperBase;
import org.Webgatherer.Api.Scraper.ScraperFactory;

import java.util.List;

/**
 * @author Rick Dane
 */
public class ScraperThread extends Thread {

	private DatarecordController datarecordController;
	private Gson gson = new Gson();

	public ScraperThread(
			DatarecordController datarecordController) {
		this.datarecordController = datarecordController;
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

			String datarecordJson = gson.toJson(datarecord);
			try {
				datarecordController.createFromJson(datarecordJson);
			}
			catch (Exception e) {
				//TODO: fix this, it is bound to fail sometimes as the entity has a unique constraint, shouldn't be
				//programming-to-exception, need to find way to avoid it getting this far
			}
			

		}
	}
}
