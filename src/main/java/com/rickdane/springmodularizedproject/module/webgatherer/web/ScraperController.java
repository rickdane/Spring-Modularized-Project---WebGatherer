package com.rickdane.springmodularizedproject.module.webgatherer.web;

import com.rickdane.springmodularizedproject.module.webgatherer.component.threadable.ScraperThread;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import com.rickdane.springmodularizedproject.module.webgatherer.service.ScraperService;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.Webgatherer.Api.Scraper.ScraperFactory;
import org.Webgatherer.ExperimentalLabs.Scraper.Core.ScraperBase;
import org.Webgatherer.ExperimentalLabs.Scraper.Generic.ScraperGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RooWebJson(jsonObject = Scraper.class)
@Controller
@RequestMapping("/scrapers")
@RooWebScaffold(path = "scrapers", formBackingObject = Scraper.class)
public class ScraperController {

	@Autowired
	ScraperService scraperService;

	@Autowired
	ScraperThread scraperThread;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Scraper scraper, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, scraper);
			return "scrapers/create";
		}
		uiModel.asMap().clear();
		scraperService.saveScraper(scraper);
		return "redirect:/scrapers/"
				+ encodeUrlPathSegment(scraper.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		// launch thread
		scraperThread.start();
		populateEditForm(uiModel, new Scraper());
		return "scrapers/create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("scraper", scraperService.findScraper(id));
		uiModel.addAttribute("itemId", id);
		return "scrapers/show";
	}

	@RequestMapping(produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			final int firstResult = page == null ? 0 : (page.intValue() - 1)
					* sizeNo;
			uiModel.addAttribute("scrapers",
					scraperService.findScraperEntries(firstResult, sizeNo));
			float nrOfPages = (float) scraperService.countAllScrapers()
					/ sizeNo;
			uiModel.addAttribute(
					"maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
							: nrOfPages));
		} else {
			uiModel.addAttribute("scrapers", scraperService.findAllScrapers());
		}
		return "scrapers/list";
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	public String update(@Valid Scraper scraper, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, scraper);
			return "scrapers/update";
		}
		uiModel.asMap().clear();
		scraperService.updateScraper(scraper);
		return "redirect:/scrapers/"
				+ encodeUrlPathSegment(scraper.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		populateEditForm(uiModel, scraperService.findScraper(id));
		return "scrapers/update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") Long id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		Scraper scraper = scraperService.findScraper(id);
		scraperService.deleteScraper(scraper);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/scrapers";

	}

	void populateEditForm(Model uiModel, Scraper scraper) {
		uiModel.addAttribute("scraper", scraper);
	}

	String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}
}
