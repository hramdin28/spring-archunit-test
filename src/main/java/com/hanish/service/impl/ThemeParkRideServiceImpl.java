package com.hanish.service.impl;

import com.hanish.model.ThemeParkRide;
import com.hanish.repository.ThemeParkRideRepository;
import com.hanish.service.ThemeParkRideService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class ThemeParkRideServiceImpl implements ThemeParkRideService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeParkRideServiceImpl.class);

    private final ThemeParkRideRepository themeParkRideRepository;

    @Override
    public Iterable<ThemeParkRide> getRides() {
        LOGGER.info("Get rides");
        return themeParkRideRepository.findAll();
    }

    @Override
    public ThemeParkRide getRide(long id) {
        LOGGER.info("Get ride by id");
        return themeParkRideRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @Override
    public ThemeParkRide createRide(ThemeParkRide themeParkRide) {
        LOGGER.info("Create ride");
        return themeParkRideRepository.save(themeParkRide);
    }
}
