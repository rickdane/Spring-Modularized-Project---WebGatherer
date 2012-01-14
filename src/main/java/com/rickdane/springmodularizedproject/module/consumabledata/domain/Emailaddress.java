package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = {"findEmailaddressesByWebsite",
        "findEmailaddressesByWebsiteAndDateLastSentIsNull"})
@RooJson
public class Emailaddress {

    public Emailaddress () {
        activeStatus = ActiveStatus.ACTIVE;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Website website;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar dateLastSent;

    @Enumerated
    private ActiveStatus activeStatus;
}
