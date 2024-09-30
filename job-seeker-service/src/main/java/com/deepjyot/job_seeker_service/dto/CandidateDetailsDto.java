package com.deepjyot.job_seeker_service.dto;

import lombok.*;

import java.util.List;

@Data
@ToString // Add this temporarily
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Getter
@Setter
public class CandidateDetailsDto extends CandidateDto {

    private List<JobDto> recommendedJobs;

    // Custom Getter
    public List<JobDto> getRecommendedJobs() {
        // Add any custom logic if needed before returning the value
        return recommendedJobs;
    }

    // Custom Setter
    public void setRecommendedJobs(List<JobDto> recommendedJobs) {
        // Add any custom logic before setting the value
        if (recommendedJobs != null && !recommendedJobs.isEmpty()) {
            this.recommendedJobs = recommendedJobs;
        } else {
            this.recommendedJobs = List.of(); // Default empty list if null or empty
        }
    }
}
