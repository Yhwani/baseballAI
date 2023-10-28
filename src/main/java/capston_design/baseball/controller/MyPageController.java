package capston_design.baseball.controller;

import capston_design.SessionConst;
import capston_design.baseball.domain.Member;
import capston_design.baseball.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/myPage")
    public String myPage(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        model.addAttribute("members",myPageService.teamInformation(loginMember));
        return "myPage";
    }
}
