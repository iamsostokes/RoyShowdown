package com.detroitlabs.royshowdown.service;

import com.detroitlabs.royshowdown.model.Job;
import com.detroitlabs.royshowdown.model.JobSearchRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class JobService {

    public JobSearchRepository fetchAllJobs(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "data.usajobs.gov");
        headers.add("User-Agent", "omar.atcho@detroitlabs.com");
        headers.add("Authorization-Key", "I21bQVc1pzre1Wo2STmhcF7TGpb7pCXVl+RXeADLzKE=");
        return restTemplate.getForObject("https://data.usajobs.gov/api/Archive?PostingStartDate=" +
                "2019-01-07&PostingEndDate=2020-01-01", JobSearchRepository.class);
    }
}
