package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.EmpVO;
import kr.co.vo.Emp_ViewVO;

@Repository
public class EmpDAOImp implements EmpDAO {

	@Inject
	private SqlSession sqlsession;
	
	// 글작성
	@Override
	public void write(EmpVO empVO) {
		sqlsession.insert("boardMapper.insert", empVO);
	}

	// 게시물 출력
	@Override
	public List<Emp_ViewVO> getList() throws Exception {
		return sqlsession.selectList("boardMapper.select");
	}

}
