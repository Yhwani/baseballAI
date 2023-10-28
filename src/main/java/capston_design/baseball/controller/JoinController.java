package capston_design.baseball.controller;

import capston_design.baseball.domain.Member;
import capston_design.baseball.service.JoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/join")
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/Form")
    public String joinForm(@ModelAttribute("member") Member member) {
        return "join/joinForm";
    }

    @PostMapping("/Form")
    public String join(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "join/joinForm";
        }
        joinService.join(member);
        return "redirect:/";
    }
}
