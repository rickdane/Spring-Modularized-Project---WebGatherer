package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import com.rickdane.springmodularizedproject.domain.User;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findWebsitesByDomainNameEquals" })
public class Website {

    @NotNull
    private String domainName;

    private String contactName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar dateLastSentEmail;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Emailaddress> emailAddressLastSentTo = new HashSet<Emailaddress>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Emailaddress> emailPrimary = new HashSet<Emailaddress>();

    @Enumerated
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> userOwner = new HashSet<User>();

    public enum Type {

        SEARCH_ENGINE, COMPANY_SITE;
    }
}
