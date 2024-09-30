package com.deepjyot.job_sphere.dto;

import java.util.Set;


public class JobDto {
    private String id;
    private String description;


    public JobDto(){}

    public JobDto(String id, String description, String company, Set<String> skills, Integer salary, Boolean isRemote, String hostName) {
        this.id = id;
        this.description = description;
        this.company = company;
        this.skills = skills;
        this.salary = salary;
        this.isRemote = isRemote;
        this.hostName = hostName;
    }

    private String company;
    private Set<String> skills;
    private Integer salary;
    private Boolean isRemote;

    private String hostName ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean getRemote() {
        return isRemote;
    }

    public void setRemote(Boolean remote) {
        isRemote = remote;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
