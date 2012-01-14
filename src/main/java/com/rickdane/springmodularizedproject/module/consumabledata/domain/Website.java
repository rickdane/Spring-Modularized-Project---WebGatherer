package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import com.rickdane.springmodularizedproject.domain.User;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateCategory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = {"findWebsitesByDomainNameEquals",
        "findWebsitesByDateLastSentEmailIsNullAndWebsiteEmailSendStatus"})
@RooJson
@RooWebJson(jsonObject = com.rickdane.springmodularizedproject.module.consumabledata.domain.Website.class)
public class Website {

    @NotNull
    private String domainName;

    private String contactName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar dateLastSentEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    private Emailaddress emailAddressLastSentTo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Emailaddress emailPrimary;

    @Enumerated
    WebsiteEmailSendStatus websiteEmailSendStatus;

    @Enumerated
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> userOwner = new HashSet<User>();

    @ManyToOne(cascade = CascadeType.ALL)
    private EmailTemplateCategory emailTemplateCategories;


    public enum Type {

        SEARCH_ENGINE, COMPANY_SITE;
    }
}
