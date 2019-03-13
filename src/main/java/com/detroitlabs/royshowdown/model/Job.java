package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
    private String PositionTitle;
    private ArrayList<SalaryRange> PositionRemuneration = new ArrayList<SalaryRange>();

    @JsonProperty("PositionTitle")
    public String getPositionTitle() {
        return PositionTitle;
    }

    @JsonProperty("PositionTitle")
    public void setPositionTitle(String positionTitle) {
        PositionTitle = positionTitle;
    }

    @JsonProperty("PositionRemuneration")
    public ArrayList<SalaryRange> getPositionRemuneration() {
        return PositionRemuneration;
    }

    @JsonProperty("PositionRemuneration")
    public void setPositionRemuneration(ArrayList<SalaryRange> positionRemuneration) {
        PositionRemuneration = positionRemuneration;
    }
}
