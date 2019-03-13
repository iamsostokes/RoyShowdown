package com.detroitlabs.royshowdown.service;

import com.detroitlabs.royshowdown.model.JobSearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JobService {

    public JobSearchRepository fetchSingleJob(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://data.usajobs.gov/api/Archive?PostingStartDate=2019-03-07&PostingEndDate=2020-01-01", JobSearchRepository.class);
    }
}
