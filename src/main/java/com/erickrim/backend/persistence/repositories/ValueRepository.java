package com.erickrim.backend.persistence.repositories;

import com.erickrim.backend.persistence.domain.QuoteLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krime on 1/25/17.
 */
@Repository
public interface ValueRepository extends CrudRepository<QuoteLine, Integer> {
}
