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
import kr.co.viewparse.EmpViewParse;
import kr.co.vo.Criteria;
import kr.co.vo.EmpVO;
import kr.co.vo.Emp_ViewVO;
import kr.co.vo.PageMaker;
import kr.co.vo.SearchForm;

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
	public void list(Model model, Criteria cri, SearchForm search) throws Exception {
		logger.info("list in");
		
		// 검색키워드, 검색라디오 Criteria 와 다른 폼에 있어 개별 전달해 setter주입함
		// 검색부분도 하나의 클래스로 만들어 전달하면 좋을듯
		cri.setSearchKeyword(search.getSearchKeyword());
		cri.setSearchType(search.getSearchType());
		
		List<Emp_ViewVO> list = service.getList(cri);
		// 화면에 출력할 데이터양식에 맞춰 파싱
		EmpViewParse evp = new EmpViewParse(list);
		model.addAttribute("list", evp.getList());

		// 페이징 관련 부분
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.getCount(cri));
		model.addAttribute("pageMaker", pageMaker);

		logger.info("list out");
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
