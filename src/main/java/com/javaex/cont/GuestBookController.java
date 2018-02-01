package com.javaex.cont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;

import com.javaex.vo.GuestVo;

@Controller
public class GuestBookController {
	@Autowired
	GuestDao dao ;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
	
	 
		
		List<GuestVo> guestList = dao.getListAll();
		model.addAttribute("guestList", guestList);
		

		return "/WEB-INF/list.jsp";
	}
	@RequestMapping("/add")
	public String add(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("content") String content ) {
	

		

		GuestVo vo = new GuestVo(1, name, password, content, "date");
		
		dao.insert(vo);

		return "redirect:/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("no2") String no2,@RequestParam("password")String password ) {
		int no2I = Integer.parseInt(no2);
		
		dao.delete2(password, no2I);
		return "redirect:/deleteform?no2="+no2;
	}
	
	@RequestMapping("deleteform")
	public String deleteform() {
		return "/WEB-INF/deleteform.jsp";
	
	} 
	

}
