package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {
    private ArrayList<Job> SearchResultItems = new ArrayList<Job>();

    @JsonProperty("SearchResultItems")
    public ArrayList<Job> getSearchResultItems() {
        return SearchResultItems;
    }

    @JsonProperty("SearchResultItems")
    public void setSearchResultItems(ArrayList<Job> searchResultItems) {
        SearchResultItems = searchResultItems;
    }
}
