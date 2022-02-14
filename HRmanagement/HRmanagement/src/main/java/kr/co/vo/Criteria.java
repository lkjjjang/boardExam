package kr.co.vo;

public class Criteria {
	
	private static final int DEFAULT_PAGE_NUM = 1;
	private static final int MAX_PAGE_NUM = 100;
	private static final int LIST_PRINT_COUNT = 5;
	private static final int DEFAULT_PER_PAGENUM = 10;
	
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	
	public Criteria() {
		page = DEFAULT_PAGE_NUM;
		perPageNum = LIST_PRINT_COUNT;
	}
	
	public void setPage(int page) {		
		this.page = page < DEFAULT_PAGE_NUM ? DEFAULT_PAGE_NUM : page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum < DEFAULT_PAGE_NUM || perPageNum > MAX_PAGE_NUM) {
			this.perPageNum = DEFAULT_PER_PAGENUM;
			return;
		}
		
		this.perPageNum = perPageNum;
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
