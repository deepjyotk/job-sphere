package com.deepjyot.job_sphere.util;

import com.deepjyot.job_sphere.dto.JobDto;
import com.deepjyot.job_sphere.entity.Job;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static JobDto toDto(Job job){
        JobDto dto = new JobDto() ;
        BeanUtils.copyProperties(job,dto);

        dto.setHostName(AppUtil.getHostname());
        return dto ;
    }

    public static Job toEntity(JobDto dto){
        Job job = new Job() ;
        BeanUtils.copyProperties(dto,job);
        return job;
    }
}
