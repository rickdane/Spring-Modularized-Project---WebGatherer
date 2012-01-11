package com.rickdane.springmodularizedproject.module.webgatherer.domain;

import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson(deepSerialize = true)
@RooJpaActiveRecord(finders = { "findScrapersByUserOwner", "findScrapersByStatus", "findScrapersByStatusAndUserOwner" })
public class Scraper {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> userOwner = new HashSet<User>();

    @Enumerated
    private ProcessStatus status;

    @Enumerated
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Campaign> campaign = new HashSet<Campaign>();

    public enum Type {

        EMAIL_SCRAPE, URL_SCRAPE;
    }
}
