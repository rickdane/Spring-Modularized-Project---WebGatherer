// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Website_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Website.entityManager;
    
    public static final EntityManager Website.entityManager() {
        EntityManager em = new Website().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Website.countWebsites() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Website o", Long.class).getSingleResult();
    }
    
    public static List<Website> Website.findAllWebsites() {
        return entityManager().createQuery("SELECT o FROM Website o", Website.class).getResultList();
    }
    
    public static Website Website.findWebsite(Long id) {
        if (id == null) return null;
        return entityManager().find(Website.class, id);
    }
    
    public static List<Website> Website.findWebsiteEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Website o", Website.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Website.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Website.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Website attached = Website.findWebsite(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Website.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Website.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Website Website.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Website merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
