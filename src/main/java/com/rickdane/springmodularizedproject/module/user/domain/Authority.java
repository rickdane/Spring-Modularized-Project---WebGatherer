package com.rickdane.springmodularizedproject.module.user.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "authorities")
@RooJson(deepSerialize = true)
public class Authority {

    @NotNull
    @Size(max = 50)
    private String username;

    @NotNull
    @Size(max = 50)
    private String authority;
}
