package com.sehyeonn.community.utility;

public class PageMaker {
	private int startPage;	// 표시되는 시작 페이지
	private int endPage;	// 표시되는 끝 페이지

	private boolean prev;	// 이전 페이지 버튼 유무
	private boolean next;	// 다음 페이지 버튼 유무
	private int total;		// 총 데이터 수
	private int amount;		// 한 페이지에 표시될 데이터 수
	
	public PageMaker(int pageNumber, int amount, int total) {
		this.amount = amount;
		this.total = total;
		this.endPage = (int)(Math.ceil(pageNumber/10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((double)total / amount));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getAmount() {
		return amount;
	}
}
