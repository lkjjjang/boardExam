package kr.co.viewparse;

import java.util.ArrayList;
import java.util.List;

import kr.co.vo.Emp_ViewVO;

public class EmpViewParse {
	
	private List<Emp_ViewVO> list = new ArrayList<Emp_ViewVO>();
	
	public EmpViewParse(List<Emp_ViewVO> list) {
		this.list = list;
		start();
	}
	
	public List<Emp_ViewVO> getList() {
		return this.list;
	}
	
	private void start() {
		for (Emp_ViewVO emp: this.list) {
			dateParse(emp);
			regNoParse(emp);
		}
	}
	
	private void dateParse(Emp_ViewVO emp) {
		int space = emp.getHire_date().indexOf(" ");
		emp.setHire_date(emp.getHire_date().substring(0, space));
		
		if (emp.getLeave_date() != null) {
			emp.setLeave_date(emp.getLeave_date().substring(0, space));
		} else {
			emp.setLeave_date("");
		}
	}
	
	private void regNoParse(Emp_ViewVO emp) {
		int birthDayLastIdx = 6;
		String birthDay = emp.getReg_no().substring(0, birthDayLastIdx);
		String serialNumber = emp.getReg_no().substring(birthDayLastIdx);
		emp.setReg_no(birthDay + "-" + serialNumber);
	}
}
