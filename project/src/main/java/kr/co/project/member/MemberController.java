package kr.co.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login.do")
	public void login() {
		// 새로운 작업
	}
	
	@PostMapping("/member/login.do")
	public String login(Model model, MemberVO vo, HttpSession sess) {
		MemberVO login = service.login(vo);
		if (login == null) {
			model.addAttribute("msg", "이메일 비밀번호를 확인하세요.");
			model.addAttribute("url", "/member/login.do");
			return "common/alert";
		} else {
			sess.setAttribute("login", login);
			return "redirect:/index.do";
		}
	}
	
	@GetMapping("/member/logout.do")
	public String logout(HttpSession sess, Model model) {
		sess.invalidate();
		model.addAttribute("msg", "로그아웃입니다.");
		model.addAttribute("url", "/index.do");
		return "common/alert";
	}
	
	@ResponseBody
	@GetMapping("/member/emailCheck.do")
	public int emailCheck(String email) {
		return service.emailCheck(email);
	}
	
	@PostMapping("/member/insert.do")
	public String insert(MemberVO vo, Model model) {
		if (service.regist(vo)) {
			
			model.addAttribute("msg", "정상적으로 가입되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "가입 오류");
			model.addAttribute("url", "regist.do");
		}
		return "common/alert";
	}
	
	@GetMapping("/member/edit.do")
	public String edit(HttpSession sess, Model model) {
		MemberVO uv = (MemberVO)sess.getAttribute("login");
		model.addAttribute("vo", service.detail(uv));
		return "member/edit";
	}
	
	@PostMapping("/member/update.do")
	public String update(MemberVO vo, Model model) {
		int r = service.update(vo);
		String msg = "";
		String url = "edit.do";
		if (r > 0) {
			msg = "정상적으로 수정되었습니다.";
		} else {
			msg = "수정 오류";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		return "common/alert";
	}
}
