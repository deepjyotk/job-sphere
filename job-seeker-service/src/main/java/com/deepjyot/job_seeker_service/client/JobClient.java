package com.deepjyot.job_seeker_service.client;
import com.deepjyot.job_seeker_service.dto.JobDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class JobClient {
    private final WebClient webClient ;


    //job/search?skills=
    public JobClient(@Value("${job.service.url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build() ;
    }

    public Mono<List<JobDto>> getRecommendedJobs(Set<String> skills){

        return this.webClient.get()
                .uri(u->u.path("search").queryParam("skills",skills).build())
                .retrieve()
                .bodyToFlux(JobDto.class)
                .doOnNext(job -> System.out.println("Retrieved job: " + job)) // Print each job
                .collectList()
                .onErrorReturn(Collections.emptyList());

    }
}
