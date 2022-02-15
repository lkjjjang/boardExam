package kr.co.dao;

import java.util.List;

import kr.co.vo.Criteria;
import kr.co.vo.EmpVO;
import kr.co.vo.Emp_ViewVO;

public interface EmpDAO {
	// 글작성
	void write(EmpVO empVO) throws Exception;
	// 게시물 목록
	List<Emp_ViewVO> getList(Criteria cri) throws Exception;
	// 게시물 갯수
	int getCount(Criteria cri) throws Exception;

}
