package com.deepjyot.job_seeker_service.service;

import com.deepjyot.job_seeker_service.client.JobClient;
import com.deepjyot.job_seeker_service.dto.CandidateDetailsDto;
import com.deepjyot.job_seeker_service.dto.CandidateDto;
import com.deepjyot.job_seeker_service.repository.CandidateRepository;
import com.deepjyot.job_seeker_service.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CandidateService {

    @Autowired
    JobClient jobClient ;

    @Autowired
    private CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Flux<CandidateDto> all() {
        return this.repository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<CandidateDetailsDto> getById(String id) {
        return this.repository.findById(id)
                .map(EntityDtoUtil::toDetailsDto)
                .flatMap( this::addRecommendedJobs);
    }

    private Mono<CandidateDetailsDto> addRecommendedJobs(CandidateDetailsDto candidateDetailsDto){
        return this.jobClient.getRecommendedJobs(candidateDetailsDto.getSkills()).
                doOnNext(candidateDetailsDto::setRecommendedJobs).thenReturn(candidateDetailsDto) ;
    }

    public Mono<CandidateDto> save(Mono<CandidateDto> mono) {
        return mono
                .map(EntityDtoUtil::toEntity)
                .flatMap(this.repository::save)
                .map(EntityDtoUtil::toDto);
    }
}