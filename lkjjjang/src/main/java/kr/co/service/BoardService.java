package kr.co.service;

import java.util.List;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

public interface BoardService {
	
	// 글작성
	void write(BoardVO boardVO) throws Exception;

	// 게시글 조회
	List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	// 게시글 갯수
	int listCount(SearchCriteria scri) throws Exception;

	// 글 뷰
	BoardVO read(int bno) throws Exception;

	// 글 업데이트
	void update(BoardVO boardVO) throws Exception;

	// 글 삭제
	void delete(int bno) throws Exception;

}
