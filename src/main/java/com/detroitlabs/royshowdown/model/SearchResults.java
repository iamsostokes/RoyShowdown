package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {
    private ArrayList<Job> SearchResultItems = new ArrayList<Job>();
    private int SearchResultCount;
//    private JobInfo jobInfo;

    @JsonProperty("SearchResultItems")
    public ArrayList<Job> getSearchResultItems() {
        return SearchResultItems;
    }

    @JsonProperty("SearchResultItems")
    public void setSearchResultItems(ArrayList<Job> searchResultItems) {
        SearchResultItems = searchResultItems;
    }

    @JsonProperty("SearchResultCount")
    public int getSearchResultCount() {
        return SearchResultCount;
    }

    @JsonProperty("SearchResultCount")
    public void setSearchResultCount(int searchResultCount) {
        SearchResultCount = searchResultCount;
    }

}
