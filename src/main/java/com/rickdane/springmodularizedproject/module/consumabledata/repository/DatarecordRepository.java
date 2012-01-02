package com.rickdane.springmodularizedproject.module.consumabledata.repository;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Datarecord.class)
public interface DatarecordRepository {
}
