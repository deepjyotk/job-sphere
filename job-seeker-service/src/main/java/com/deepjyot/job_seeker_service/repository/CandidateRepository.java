package com.deepjyot.job_seeker_service.repository;

import com.deepjyot.job_seeker_service.entity.Candidate;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends ReactiveCrudRepository<Candidate, String>
{
}
