package com.demoshopping.service;

import org.springframework.stereotype.Service;

import com.demoshopping.DTO.PaginationDTO;

@Service
public interface IPaginateService {
    public PaginationDTO getPaginationInfoByCategory(int cID, String byPrice,String bySize, int page,int limitOfPages);
}
