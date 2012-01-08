package com.rickdane.springmodularizedproject.module.webgatherer.web;

import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = Scraper.class)
@Controller
@RequestMapping("/scrapers")
@RooWebScaffold(path = "scrapers", formBackingObject = Scraper.class)
public class ScraperController {
}
