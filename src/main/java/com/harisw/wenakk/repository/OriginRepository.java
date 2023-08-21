package com.harisw.wenakk.repository;

import com.harisw.wenakk.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer> {
}
