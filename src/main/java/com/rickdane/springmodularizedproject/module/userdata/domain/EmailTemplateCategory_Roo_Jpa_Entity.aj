// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.userdata.domain;

import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateCategory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect EmailTemplateCategory_Roo_Jpa_Entity {
    
    declare @type: EmailTemplateCategory: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long EmailTemplateCategory.id;
    
    @Version
    @Column(name = "version")
    private Integer EmailTemplateCategory.version;
    
    public Long EmailTemplateCategory.getId() {
        return this.id;
    }
    
    public void EmailTemplateCategory.setId(Long id) {
        this.id = id;
    }
    
    public Integer EmailTemplateCategory.getVersion() {
        return this.version;
    }
    
    public void EmailTemplateCategory.setVersion(Integer version) {
        this.version = version;
    }
    
}
