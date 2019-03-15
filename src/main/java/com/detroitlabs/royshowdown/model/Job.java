package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
   // private String PositionTitle = "default job position";
    private ArrayList<SalaryRange> PositionRemuneration = new ArrayList<SalaryRange>();

    private JobInfo MatchedObjectDescriptor;

    @JsonProperty("MatchedObjectDescriptor")
    public JobInfo getMatchedObjectDescriptor() {
        return MatchedObjectDescriptor;
    }


    @JsonProperty("MatchedObjectDescriptor")
    public void setMatchedObjectDescriptor(JobInfo matchedObjectDescriptor) {
        MatchedObjectDescriptor = matchedObjectDescriptor;
    }

//    public String getPositionTitle() {
//        return PositionTitle;
//    }

}
