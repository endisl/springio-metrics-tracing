package com.endiluamba.service.controller;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Set;

public class AvailabilityController {

    @GetMapping("/availability/{console}")
    Map<String, Object> getAvailability(@PathVariable String console) {
        return Map.of("console", console, "available", checkAvailability(console));
    }

    private boolean checkAvailability(String console) {
        Assert.state(validate(console), () -> "the console specified, " + console + ", is not valid.");
        return switch (console) {
            case "ps5" -> throw new RuntimeException("Service exception");
            case "xbox" -> true;
            default -> false;
        };
    }

    private boolean validate(String console) {
        return StringUtils.hasText(console) && Set.of("ps5", "ps4", "switch", "xbox").contains(console);
    }
}
