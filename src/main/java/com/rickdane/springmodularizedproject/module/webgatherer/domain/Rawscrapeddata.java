package com.rickdane.springmodularizedproject.module.webgatherer.domain;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findRawscrapeddatasByRawscrapeddatamigrationstatus", "findRawscrapeddatasByRawscrapeddatamigrationstatusAndCampaign" })
public class Rawscrapeddata {

    private String url;

    private String emailAddress;

    private String text;

    @Enumerated
    private Rawscrapeddatamigrationstatus rawscrapeddatamigrationstatus;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Campaign> campaign = new HashSet<Campaign>();
}
