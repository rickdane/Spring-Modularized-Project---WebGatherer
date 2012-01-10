package com.rickdane.springmodularizedproject.module.webgatherer.domain;

import com.rickdane.springmodularizedproject.domain.User;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson(deepSerialize = true)
@RooJpaActiveRecord(finders = { "findScrapersByIsProcessedNot", "findScrapersByUserOwner", "findScrapersByUsedNot", "findScrapersByStatus" })
public class Scraper {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> userOwner = new HashSet<User>();

    private Boolean isProcessed;

    @NotNull
    private Boolean used;

    @Enumerated
    private ProcessStatus status;

    public static TypedQuery<com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper> findScrapersByIsProcessedNot(Boolean isProcessed) {
        if (isProcessed == null) throw new IllegalArgumentException("The isProcessed argument is required");
        EntityManager em = entityManager();
        TypedQuery<Scraper> q = em.createNamedQuery("select * from Scraper where isProcessed is not :isProcessed", Scraper.class);
        String pause = "";
        q.setParameter("isProcessed", isProcessed);
        return q;
    }
}
