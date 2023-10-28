package capston_design.baseball.controller;

import capston_design.SessionConst;
import capston_design.baseball.domain.Member;
import capston_design.baseball.domain.Strike;
import capston_design.baseball.service.StrikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final StrikeService strikeService;
    private Strike value = null;
    private Member member = null;

    @GetMapping("/")
    public String home(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        // 세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home";
        }
        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        if (value == null) {
            model.addAttribute("strikeOrBall", false);
        }else{
            model.addAttribute("strikeOrBall", value);
        }
        model.addAttribute("httpMember",member);
        return "loginHome";
    }

    @ResponseBody
    @PostMapping("/")
    public String update(@RequestBody Strike strike) {
        member = strikeService.update(strike, Long.valueOf(1));
        value = strike;
        return strike.isStrike() ? "strike" : "ball";
    }

    @GetMapping("/hit")
    public String hitButton(){
        strikeService.hitUpdate(member.getId());
        member = null;
        value = null;
        return "redirect:/";
    }
    @GetMapping("/out")
    public String outButton(){
        strikeService.outUpdate(member.getId());
        member = null;
        value = null;
        return "redirect:/";
    }

}
