// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.user.domain;

import com.rickdane.springmodularizedproject.module.user.domain.Appuser;
import com.rickdane.springmodularizedproject.module.user.domain.Emailaddress;
import java.util.Set;

privileged aspect Appuser_Roo_JavaBean {
    
    public String Appuser.getUsername() {
        return this.username;
    }
    
    public void Appuser.setUsername(String username) {
        this.username = username;
    }
    
    public Boolean Appuser.getEnabled() {
        return this.enabled;
    }
    
    public void Appuser.setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    public String Appuser.getPassword() {
        return this.password;
    }
    
    public void Appuser.setPassword(String password) {
        this.password = password;
    }
    
    public Set<Emailaddress> Appuser.getEmailaddresses() {
        return this.emailaddresses;
    }
    
    public void Appuser.setEmailaddresses(Set<Emailaddress> emailaddresses) {
        this.emailaddresses = emailaddresses;
    }
    
}
