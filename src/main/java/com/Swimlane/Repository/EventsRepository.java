package com.Swimlane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Swimlane.Entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, String> {

}
