package com.sushavi.stats.repository;

import com.sushavi.stats.entity.Players;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Players, Long> {
}
