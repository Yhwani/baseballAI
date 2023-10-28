package capston_design.baseball.controller;

import capston_design.baseball.domain.Strike;
import capston_design.baseball.service.StrikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/baseball")
public class StrikeController {
    private final StrikeService strikeService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String update(@RequestBody Strike strike){
        strikeService.update(strike, Long.valueOf(1));
        return "redirect:/";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String homepage(){
        return "redirect:/";
    }
}
