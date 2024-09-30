package com.deepjyot.job_seeker_service.dto;


import lombok.Data;

import java.util.Set;

@Data
public class CandidateDto {

    private String id;
    private String name;
    private Set<String> skills;
    private String hostName;

    public CandidateDto(){}

    // Custom Constructor
    public CandidateDto(String id, String name, Set<String> skills, String hostName) {
        this.id = id != null && !id.trim().isEmpty() ? id : "Default ID";
        this.name = name != null && !name.trim().isEmpty() ? name : "Anonymous";
        this.skills = skills != null && !skills.isEmpty() ? skills : Set.of("Unspecified");
        this.hostName = hostName != null && !hostName.trim().isEmpty() ? hostName : "Unknown Host";
    }

    // Custom Getter for id
    public String getId() {
        return id == null ? "Unknown ID" : id; // Return a default if id is null
    }

    // Custom Setter for id
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            this.id = "Default ID"; // Assign a default value if the id is invalid
        }
    }

    // Custom Getter for name
    public String getName() {
        return name == null ? "Anonymous" : name; // Return default if name is null
    }

    // Custom Setter for name
    public void setName(String name) {
        this.name = name != null && !name.trim().isEmpty() ? name : "Anonymous"; // Validate name
    }

    // Custom Getter for skills
    public Set<String> getSkills() {
        return skills == null ? Set.of("Unspecified") : skills; // Return default if skills are null
    }

    // Custom Setter for skills
    public void setSkills(Set<String> skills) {
        if (skills != null && !skills.isEmpty()) {
            this.skills = skills;
        } else {
            this.skills = Set.of("Unspecified"); // Assign default skills if null/empty
        }
    }

    // Custom Getter for hostName
    public String getHostName() {
        return hostName == null ? "Unknown Host" : hostName; // Return default if hostName is null
    }

    // Custom Setter for hostName
    public void setHostName(String hostName) {
        this.hostName = hostName != null && !hostName.trim().isEmpty() ? hostName : "Unknown Host"; // Validate hostName
    }
}
