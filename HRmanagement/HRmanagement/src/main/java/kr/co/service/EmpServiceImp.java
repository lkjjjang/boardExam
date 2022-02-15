package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.EmpDAO;
import kr.co.vo.Criteria;
import kr.co.vo.EmpVO;
import kr.co.vo.Emp_ViewVO;

@Service
public class EmpServiceImp implements EmpService {

	@Inject
	private EmpDAO dao;
	
	@Override
	public void write(EmpVO empVO) throws Exception {
		dao.write(empVO);
	}

	@Override
	public List<Emp_ViewVO> getList(Criteria cri) throws Exception {
		return dao.getList(cri);
	}

	@Override
	public int getCount(Criteria cri) throws Exception {
		return dao.getCount(cri);
	}
	

}
