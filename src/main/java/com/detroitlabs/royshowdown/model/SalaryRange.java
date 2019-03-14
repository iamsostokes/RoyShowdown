package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryRange {
    private String MaximumRange;

    @JsonProperty("MaximumRange")
    public String getMaximumRange() {
        return MaximumRange;
    }

    @JsonProperty("MaximumRange")
    public void setMaximumRange(String maximumRange) {
        MaximumRange = maximumRange;
    }
}
