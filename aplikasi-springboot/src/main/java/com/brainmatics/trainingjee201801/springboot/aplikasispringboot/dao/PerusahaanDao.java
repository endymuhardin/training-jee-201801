package com.brainmatics.trainingjee201801.springboot.aplikasispringboot.dao;

import com.brainmatics.trainingjee201801.springboot.aplikasispringboot.entity.Perusahaan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PerusahaanDao extends PagingAndSortingRepository<Perusahaan, String> {
    
}
