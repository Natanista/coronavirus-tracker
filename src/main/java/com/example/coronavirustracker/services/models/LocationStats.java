package com.example.coronavirustracker.services.models;

import lombok.Data;

@Data
public class LocationStats {

    private String state;
    private String country;
    private int latestTotal;
    private int diffFromPrevDay;
}
