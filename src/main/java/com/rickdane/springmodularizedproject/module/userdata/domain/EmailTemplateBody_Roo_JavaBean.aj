// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.userdata.domain;

import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateBody;
import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateCategory;
import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateStatus;

privileged aspect EmailTemplateBody_Roo_JavaBean {
    
    public String EmailTemplateBody.getBody() {
        return this.body;
    }
    
    public void EmailTemplateBody.setBody(String body) {
        this.body = body;
    }
    
    public EmailTemplateStatus EmailTemplateBody.getEmailTemplateStatus() {
        return this.emailTemplateStatus;
    }
    
    public void EmailTemplateBody.setEmailTemplateStatus(EmailTemplateStatus emailTemplateStatus) {
        this.emailTemplateStatus = emailTemplateStatus;
    }
    
    public EmailTemplateCategory EmailTemplateBody.getEmailTemplateCategory() {
        return this.emailTemplateCategory;
    }
    
    public void EmailTemplateBody.setEmailTemplateCategory(EmailTemplateCategory emailTemplateCategory) {
        this.emailTemplateCategory = emailTemplateCategory;
    }
    
}