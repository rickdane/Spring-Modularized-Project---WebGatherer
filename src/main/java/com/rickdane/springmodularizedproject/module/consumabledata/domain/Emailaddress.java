package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEmailaddressesByWebsite" })
@RooJson
public class Emailaddress {

	@ManyToOne(cascade = CascadeType.ALL)
	private Website website;

	private String email;
}
