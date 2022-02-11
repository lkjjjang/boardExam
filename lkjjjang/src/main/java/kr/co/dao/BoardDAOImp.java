package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) {
		sqlSession.insert("boardMapper.insert", boardVO);
	}

	// 게시글 조회
	@Override
	public List<BoardVO> list(SearchCriteria scri) {
		return sqlSession.selectList("boardMapper.listPage", scri);
	}
	
	// 게시글 갯수
	@Override
	public int listCount(SearchCriteria scri) {
		return sqlSession.selectOne("boardMapper.listCount", scri);
	}
	
	// 글 뷰
	@Override
	public BoardVO read(int bno) {
		return sqlSession.selectOne("boardMapper.read", bno);
	}

	@Override
	public void update(BoardVO boardVO) {
		sqlSession.update("boardMapper.update", boardVO);
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete("boardMapper.delete", bno);
	}
	
	
	
}
