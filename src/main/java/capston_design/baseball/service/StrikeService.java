package capston_design.baseball.service;

import capston_design.baseball.domain.Member;
import capston_design.baseball.domain.Strike;
import capston_design.baseball.repository.StrikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StrikeService {
    private final StrikeRepository strikeRepository;

    @Transactional
    public Member update(Strike strike, Long id) {
        return strikeRepository.update(strike, id);
    }

    public Member find(Long id) {
        return strikeRepository.find(id);
    }

    @Transactional
    public void hitUpdate(Long id) {strikeRepository.hitUpdate(id);}
    @Transactional
    public void outUpdate(Long id){strikeRepository.outUpdate(id);}
}
