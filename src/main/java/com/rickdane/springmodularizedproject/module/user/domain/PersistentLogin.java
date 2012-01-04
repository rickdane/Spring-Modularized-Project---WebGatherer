package com.rickdane.springmodularizedproject.module.user.domain;

import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "persistent_logins")
public class PersistentLogin {

    @NotNull
    @Size(max = 64)
    private String username;

    @NotNull
    @Size(max = 64)
    private String series;

    @NotNull
    @Size(max = 64)
    private String token;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar last_used;
}
