package com.hanish.service;

import com.hanish.model.ThemeParkRide;


public interface ThemeParkRideService {

    /**
     * Find all rides
     *
     * @return
     */
    Iterable<ThemeParkRide> getRides();

    /**
     * Get ride by id
     *
     * @param id
     * @return
     */
    ThemeParkRide getRide( long id);

    /**
     * Create ride
     *
     * @param themeParkRide
     * @return
     */
    ThemeParkRide createRide( ThemeParkRide themeParkRide);
}
