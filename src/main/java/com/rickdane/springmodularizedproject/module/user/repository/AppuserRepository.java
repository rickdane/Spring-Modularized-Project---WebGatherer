package com.rickdane.springmodularizedproject.module.user.repository;

import com.rickdane.springmodularizedproject.module.user.domain.Appuser;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Appuser.class)
public interface AppuserRepository {
}
