package kr.co.vo;

public class SearchForm extends Criteria {
	
	private String searchKeyword = "";
	private String searchType = "";
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	@Override
	public String toString() {
		return "SearchForm [searchKeyword=" + searchKeyword + ", searchType=" + searchType + "]";
	}
	
	

}
