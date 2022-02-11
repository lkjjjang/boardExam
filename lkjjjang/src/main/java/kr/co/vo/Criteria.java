package kr.co.vo;

public class Criteria {
	private static final int VIEW_COUNT = 5;
	private static final int DFAULT_PAGE = 1;
	private static final int MIN_PAGENUM = 0;
	private static final int MAX_PAGENUM = 100;
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	
	public Criteria() {
		this.page = DFAULT_PAGE;
		this.perPageNum = VIEW_COUNT;
	}
	
	public void setPage(int page) {
		if (page < 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int pageNum) {
		if (pageNum <= MIN_PAGENUM || pageNum > MAX_PAGENUM) {
			this.perPageNum = VIEW_COUNT;
			return;
		}
		this.perPageNum = pageNum;
	}
	
	public int getPage() {
		return this.page;
	}
	
	public int getPageStart() {
		return (this.page - 1) * this.perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getRowStart() {
		this.rowStart = ((this.page - 1) * this.perPageNum) + 1;
		return this.rowStart;
	}
	
	public int getRowEnd() {
		this.rowEnd = this.rowStart + this.perPageNum - 1;
		return this.rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}	
	
}
