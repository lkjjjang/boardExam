package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

public interface BoardDAO {

	// 글 작성
	void write(BoardVO boardVO) throws Exception;

	// 글 조회
	List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	// 게시글 갯수
	int listCount(SearchCriteria scri) throws Exception;

	// 글 뷰
	BoardVO read(int bno) throws Exception;

	void update(BoardVO boardVO) throws Exception;

	void delete(int bno) throws Exception;

}
