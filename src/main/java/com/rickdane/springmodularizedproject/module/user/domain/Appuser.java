package com.rickdane.springmodularizedproject.module.user.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity(table = "users")
public class Appuser {

    @NotNull
    @Size(max = 100)
    private String username;

    @NotNull
    private Boolean enabled;

    @NotNull
    @Size(max = 100)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Emailaddress> emailaddresses = new HashSet<Emailaddress>();
}
