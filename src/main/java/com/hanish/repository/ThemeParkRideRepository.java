package com.hanish.repository;

import com.hanish.model.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeParkRideRepository extends JpaRepository<ThemeParkRide, Long> {
}
