package com.rickdane.springmodularizedproject.module.user.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "users")
@RooJson(deepSerialize = true)
public class Appuser {

    @NotNull
    @Size(max = 100)
    private String username;

    @NotNull
    @Size(max = 100)
    private String password;

    @NotNull
    private Boolean enabled;
}
