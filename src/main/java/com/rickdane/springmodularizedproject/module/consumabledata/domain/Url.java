package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.Calendar;
import java.util.List;
import javax.*;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findUrlsByUrlEqualsAndCampaign", "findUrlsByUrlStatusAndCampaign" })
public class Url {

    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Campaign campaign;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Website website;

    @Enumerated
    @NotNull
    private UrlStatus urlStatus = UrlStatus.ACTIVE;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar dateLastPostedTo;

    
    @Transactional
    public void persist() {
        if (url != null && campaign != null && website != null) {
            TypedQuery<Url> queryU = Url.findUrlsByUrlEqualsAndCampaign(url, campaign);
            if (!queryU.getResultList().isEmpty()) {
                return;
            }
            TypedQuery<UrlBlockPattern> QueryUB = UrlBlockPattern.findUrlBlockPatternsByPatternLike(website.getDomainName());
            if (QueryUB.getResultList().isEmpty()) {
                if (this.entityManager == null) this.entityManager = entityManager();
                this.entityManager.persist(this);
            }
        }
    }
}
