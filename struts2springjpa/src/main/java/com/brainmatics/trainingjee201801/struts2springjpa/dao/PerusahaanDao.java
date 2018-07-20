package com.brainmatics.trainingjee201801.struts2springjpa.dao;

import com.brainmatics.trainingjee201801.struts2springjpa.entity.Perusahaan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PerusahaanDao extends PagingAndSortingRepository<Perusahaan, String> {
    
}
