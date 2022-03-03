package com.demoshopping.DTO;

public class PaginationDTO {
	public int totalPage, startPage, endPage,currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PaginationDTO [totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", currentPage=" + currentPage + "]";
	}
	
}
