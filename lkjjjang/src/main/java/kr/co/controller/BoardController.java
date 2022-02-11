package kr.co.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;
import kr.co.vo.PageMaker;
import kr.co.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@javax.inject.Inject()
	private BoardService service;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, SearchCriteria scri) throws Exception {
		logger.info("list in");
		System.out.println(scri.toString());
		model.addAttribute("list", service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
	
		logger.info("list out");
		return "/board/list";
	}
	
	@RequestMapping(value = "readView", method = RequestMethod.GET)
	public void readView(BoardVO boardVO, Model model) throws Exception {
		logger.info("readView in");
		
		model.addAttribute("read", service.read(boardVO.getBno()));
		
		logger.info("readView out");
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		logger.info("write in");
		service.write(boardVO);
		logger.info("write out");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "writeView", method = RequestMethod.GET)
	public void writeView() {
		logger.info("writeView in");
		logger.info("writeView out");
	}
	
	// 게시판 수정뷰
	@RequestMapping(value = "updateView", method = RequestMethod.GET)
	public String updateView(Model model, BoardVO boardVO) throws Exception{
		logger.info("updateView in");
		model.addAttribute("update", service.read(boardVO.getBno()));
		logger.info("updateView in");
		return "/board/updateView";
	}
	
	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		logger.info("update");
		service.update(boardVO);
		return "redirect:/board/list";
	}
	
	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		logger.info("delete");
		service.delete(boardVO.getBno());
		return "redirect:/board/list";
	}

	
}
