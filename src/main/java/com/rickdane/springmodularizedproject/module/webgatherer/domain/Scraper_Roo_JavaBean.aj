// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.webgatherer.domain;

import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.ProcessStatus;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import java.util.Set;

privileged aspect Scraper_Roo_JavaBean {
    
    public String Scraper.getName() {
        return this.name;
    }
    
    public void Scraper.setName(String name) {
        this.name = name;
    }
    
    public Set<User> Scraper.getUserOwner() {
        return this.userOwner;
    }
    
    public void Scraper.setUserOwner(Set<User> userOwner) {
        this.userOwner = userOwner;
    }
    
    public Boolean Scraper.getIsProcessed() {
        return this.isProcessed;
    }
    
    public void Scraper.setIsProcessed(Boolean isProcessed) {
        this.isProcessed = isProcessed;
    }
    
    public Boolean Scraper.getUsed() {
        return this.used;
    }
    
    public void Scraper.setUsed(Boolean used) {
        this.used = used;
    }
    
    public ProcessStatus Scraper.getStatus() {
        return this.status;
    }
    
    public void Scraper.setStatus(ProcessStatus status) {
        this.status = status;
    }
    
}
