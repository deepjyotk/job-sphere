package com.deepjyot.job_sphere.service;

import com.deepjyot.job_sphere.dto.JobDto;
import com.deepjyot.job_sphere.repository.JobRepository;
import com.deepjyot.job_sphere.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public Flux<JobDto> allJobs() {
        var res  =  this.repository.findAll() ;

        var res2 = res.map(EntityDtoUtil::toDto);

        return res2 ;
    }

    public Flux<JobDto> jobsBySkillsIn(Set<String> skills) {
        return this.repository.findBySkillsIn(skills)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<JobDto> save(Mono<JobDto> mono) {
        return mono
                .map(EntityDtoUtil::toEntity)
                .flatMap(this.repository::save)
                .map(EntityDtoUtil::toDto);
    }
}