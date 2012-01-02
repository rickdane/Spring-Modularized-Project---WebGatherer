package com.rickdane.springmodularizedproject.module.webgatherer.web;

import com.rickdane.springmodularizedproject.module.webgatherer.component.threadable.ScraperThreadManager;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = Scraper.class)
@Controller
@RequestMapping("/scrapers")
@RooWebScaffold(path = "scrapers", formBackingObject = Scraper.class)
public class ScraperController {
	
	@Autowired
	ScraperThreadManager scraperThreadManager;

	
	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Scraper());
		// launch thread
		scraperThreadManager.startThread();
		return "scrapers/create";
	}
	
}
