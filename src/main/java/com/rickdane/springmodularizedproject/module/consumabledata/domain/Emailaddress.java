package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.*;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = {"findEmailaddressesByWebsite", "findEmailaddressesByWebsiteAndDateLastSentIsNull", "findEmailaddressesByEmailEqualsAndWebsite"})
public class Emailaddress {

    @ManyToOne(cascade = CascadeType.ALL)
    private Website website;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar dateLastSent;

    @Enumerated
    private ActiveStatus activeStatus;

    public Emailaddress() {
        activeStatus = ActiveStatus.ACTIVE;
    }

    @Transactional
    public void persist() {

        //business rule: disallow creating multiple emailaddresses for same website
        if (website != null) {
            TypedQuery<Emailaddress> queryE = Emailaddress.findEmailaddressesByEmailEqualsAndWebsite(email, website);

            if (!queryE.getResultList().isEmpty()) {
                return;
            }
        }

        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
}
