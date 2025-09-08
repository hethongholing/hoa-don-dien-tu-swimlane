package com.Swimlane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Swimlane.Entity.SkuMap;

@Repository
public interface SkuMapRepository extends JpaRepository<SkuMap, String> {

}
