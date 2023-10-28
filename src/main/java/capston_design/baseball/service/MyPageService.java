package capston_design.baseball.service;

import capston_design.baseball.domain.Member;
import capston_design.baseball.repository.MyPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageService {
    private final MyPageRepository myPageRepository;

    public List<Member> teamInformation(Member member){
        return myPageRepository.teamInformation(member);
    }
}
