package com.deepjyot.job_seeker_service.util;

import com.deepjyot.job_seeker_service.dto.CandidateDetailsDto;
import com.deepjyot.job_seeker_service.dto.CandidateDto;
import com.deepjyot.job_seeker_service.entity.Candidate;
import com.deepjyot.job_seeker_service.util.AppUtil;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static CandidateDto toDto(Candidate candidate) {
        CandidateDto dto = new CandidateDto();
        BeanUtils.copyProperties(candidate, dto);
        dto.setHostName(AppUtil.getHostname());
        return dto;
    }
    public static CandidateDetailsDto toDetailsDto(Candidate candidate) {
        CandidateDetailsDto dto = new CandidateDetailsDto();
        BeanUtils.copyProperties(candidate, dto);
        dto.setHostName(AppUtil.getHostname());
        return dto;
    }

    public static Candidate toEntity(CandidateDto dto) {
        Candidate entity = new Candidate();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}