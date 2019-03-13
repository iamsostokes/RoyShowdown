package com.detroitlabs.royshowdown.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchRepository {
    private String LanguageCode;
    private SearchResults SearchResult;

    @JsonProperty("SearchResult")
    public SearchResults getSearchResult() {
        return SearchResult;
    }

    @JsonProperty("SearchResult")
    public void setSearchResult(SearchResults searchResult) {
        SearchResult = searchResult;
    }

    @JsonProperty("LanguageCode")
    public String getLanguageCode() {
        return LanguageCode;
    }

    @JsonProperty("LanguageCode")
    public void setLanguageCode(String languageCode) {
        LanguageCode = languageCode;
    }
}
