package com.rickdane.springmodularizedproject.module.webgatherer.repository;

import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Scraper.class)
public interface ScraperRepository {
}
