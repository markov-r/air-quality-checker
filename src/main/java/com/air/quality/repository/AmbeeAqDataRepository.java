package com.air.quality.repository;

import com.air.quality.entity.AmbeeAqData;
import org.springframework.data.repository.CrudRepository;

public interface AmbeeAqDataRepository extends CrudRepository<AmbeeAqData, Long> {
}
