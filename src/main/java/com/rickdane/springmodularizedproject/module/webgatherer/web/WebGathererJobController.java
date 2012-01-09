package com.rickdane.springmodularizedproject.module.webgatherer.web;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.rickdane.springmodularizedproject.api.transport.TransportBase;
import com.rickdane.springmodularizedproject.api.transport.WebGathererJobJsonTransport;
import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

import javax.persistence.TypedQuery;


@Controller
@RequestMapping("/webgathererjobs")
public class WebGathererJobController {
	
	@RequestMapping(value = "/getPendingJobToLaunch", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> launchJob(@RequestBody String json) {
		WebGathererJobJsonTransport webGathererJJT = WebGathererJobJsonTransport.fromJsonToWebGathererJobJsonTransport(json);

        HttpHeaders headers = new HttpHeaders();
        
		User validatedUser = User.getAuthenticatedUser(webGathererJJT.getUserName(), webGathererJJT.getPasswordEncrytped());
		if (validatedUser == null) {
	        headers.add("Content-Type", "application/json");
	        return new ResponseEntity<String>(headers, HttpStatus.FORBIDDEN);
		}
        
        Scraper scraperEx = new Scraper();
        scraperEx.setName(webGathererJJT.getJobType());
        Set<User> users = new HashSet<User>();
        users.add(validatedUser);
        scraperEx.setUserOwner(users);

        //TODO: account for concurrency
        
        TypedQuery <Scraper> unprocessedScrapers = Scraper.findScrapersByIsProcessedNot(false);
        Scraper scraper = unprocessedScrapers.getSingleResult();
        
        String jsonScraper = scraper.toString();
 
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(jsonScraper, HttpStatus.CREATED);
    }

	
	
}

