package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson(deepSerialize = true)
@RooJpaActiveRecord(finders = { "findCampaignsByNameEquals", "findCampaignsByCampaignEmailScrapeOptions" })
public class Campaign {

    private String name;

    @Enumerated
    CampaignEmailScrapeOptions campaignEmailScrapeOptions;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Datarecord> datarecords = new HashSet<Datarecord>();
}
