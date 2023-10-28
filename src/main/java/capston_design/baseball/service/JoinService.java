package capston_design.baseball.service;

import capston_design.baseball.domain.Member;
import capston_design.baseball.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinService {

    private final JoinRepository joinRepository;

    @Transactional
    public void join(Member member) {
        validateDuplicate(member);
        joinRepository.join(member);
    }

    private void validateDuplicate(Member member) {
        List<Member> findMembers = new ArrayList<>(joinRepository.findByAll(member.getNameId()));
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
