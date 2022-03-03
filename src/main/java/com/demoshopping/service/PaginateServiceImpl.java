package com.demoshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.IProductDAO;
import com.demoshopping.DAO.ProductDAOImpl;
import com.demoshopping.DTO.PaginationDTO;

@Service
public class PaginateServiceImpl implements IPaginateService{
	@Autowired
	public IProductDAO productDAO;
	
	
	@Override
	public PaginationDTO getPaginationInfoByCategory(int cID,String byPrice,String bySize,int page,int limitOfPages) {
		PaginationDTO pDto = new PaginationDTO();
		double totalProductByCategoryFiltered = (double)productDAO.getProductsByCategoryFilteredByPriceAndSize(cID, byPrice, bySize).size();
		double limitProductsOfAPage = (double)ProductDAOImpl.limit;
		int totalPage = (int)Math.ceil(totalProductByCategoryFiltered /limitProductsOfAPage);
		pDto.setTotalPage(totalPage);

			int endPage = ((page-1)/limitOfPages+1)*limitOfPages;
			endPage = endPage > totalPage ? totalPage:endPage;
			if(endPage>=limitOfPages) {
				pDto.setCurrentPage(page<=endPage?page:endPage);
				pDto.setStartPage(endPage - limitOfPages + 1);
				pDto.setEndPage(endPage);
			}
			else {
				pDto.setCurrentPage(page<=endPage?page:endPage);
				pDto.setStartPage(1);
				pDto.setEndPage(endPage);
			}	
		
		
		
		return pDto;
	}
}
