// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.WebsiteEmailSendStatus;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

privileged aspect Website_Roo_Controller_Json {
    
    @RequestMapping(value = "/{id}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> Website.showJson(@PathVariable("id") Long id) {
        Website website = Website.findWebsite(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (website == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(website.toJson(), headers, HttpStatus.OK);
    }
    
    @RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> Website.listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Website> result = Website.findAllWebsites();
        return new ResponseEntity<String>(Website.toJsonArray(result), headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> Website.createFromJson(@RequestBody String json) {
        Website website = Website.fromJsonToWebsite(json);
        website.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> Website.createFromJsonArray(@RequestBody String json) {
        for (Website website: Website.fromJsonArrayToWebsites(json)) {
            website.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> Website.updateFromJson(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Website website = Website.fromJsonToWebsite(json);
        if (website.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> Website.updateFromJsonArray(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        for (Website website: Website.fromJsonArrayToWebsites(json)) {
            if (website.merge() == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> Website.deleteFromJson(@PathVariable("id") Long id) {
        Website website = Website.findWebsite(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (website == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        website.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(params = "find=ByDateLastSentEmailIsNullAndWebsiteEmailSendStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> Website.jsonFindWebsitesByDateLastSentEmailIsNullAndWebsiteEmailSendStatus(@RequestParam("websiteEmailSendStatus") WebsiteEmailSendStatus websiteEmailSendStatus) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Website.toJsonArray(Website.findWebsitesByDateLastSentEmailIsNullAndWebsiteEmailSendStatus(websiteEmailSendStatus).getResultList()), headers, HttpStatus.OK);
    }
    
    @RequestMapping(params = "find=ByDomainNameEquals", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> Website.jsonFindWebsitesByDomainNameEquals(@RequestParam("domainName") String domainName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Website.toJsonArray(Website.findWebsitesByDomainNameEquals(domainName).getResultList()), headers, HttpStatus.OK);
    }
    
}
