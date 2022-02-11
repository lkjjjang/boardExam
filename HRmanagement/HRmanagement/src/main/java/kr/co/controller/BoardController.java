package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.EmpService;
import kr.co.vo.EmpVO;
import kr.co.vo.Emp_ViewVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Inject
	private EmpService service;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test() {
		
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list in");
		
		List<Emp_ViewVO> list = service.getList();
		for (Emp_ViewVO emp: list) {
			regNoParse(emp);
			dateParse(emp);
			System.out.println(emp.toString());
		}
		
		model.addAttribute("list", list);
		
		
		logger.info("list out");
	}
	
	private void dateParse(Emp_ViewVO emp) {
		int space = emp.getHire_date().indexOf(" ");
		emp.setHire_date(emp.getHire_date().substring(0, space));
		
		if (emp.getLeave_date().length() > 1) {
			emp.setLeave_date(emp.getLeave_date().substring(0, space));
		}
		
	}
	
	private void regNoParse(Emp_ViewVO emp) {
		int birthDayLastIdx = 6;
		String birthDay = emp.getReg_no().substring(0, birthDayLastIdx);
		String serialNumber = emp.getReg_no().substring(birthDayLastIdx);
		emp.setReg_no(birthDay + "-" + serialNumber);
	}
	
	@RequestMapping(value = "writeView", method = RequestMethod.GET)
	public void writeView() {
		logger.info("writeView in");
		logger.info("writeView out");
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(EmpVO empVO) throws Exception {
		logger.info("write in");
		
		System.out.println(empVO.toString());
		service.write(empVO);
		
		
		logger.info("write out");
		return "redirect:/board/list";
	}
	
	
}
