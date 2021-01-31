package com.hanish.controller;

import com.hanish.model.ThemeParkRide;
import com.hanish.service.ThemeParkRideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ThemeParkRideController {
    private final ThemeParkRideService themeParkRideService;

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideService.getRides();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable long id) {
        return themeParkRideService.getRide(id);
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideService.createRide(themeParkRide);
    }
}