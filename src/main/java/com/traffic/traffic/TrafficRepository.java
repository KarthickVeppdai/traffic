package com.traffic.traffic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic, Long> {


    Integer countByRoad(Integer road);

    Integer countByCategory(Integer vechical);
}
