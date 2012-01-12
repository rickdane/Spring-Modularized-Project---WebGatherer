package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEmailaddressesByWebsite" })
public class Emailaddress {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Website> website = new HashSet<Website>();

    private String email;
}
