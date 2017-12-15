package com.freedomsoftwaresolutions.OutputDataService.Entities;

public final class OutputData {
    private final String city;
    public OutputData(String city) {
        this.city = city;
    }

    public String toString() {
        return city;
    }
}
