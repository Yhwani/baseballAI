package capston_design.baseball.repository;

import capston_design.baseball.domain.Member;
import capston_design.baseball.domain.Strike;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StrikeRepository {

    private final EntityManager em;

    public Member update(Strike strike, Long id) {
        Member member = em.find(Member.class, id);
        member.update(strike.isStrike());
        member.hitRateUpdate();
        em.persist(member);
        em.flush();
        return member;
    }

    public void hitUpdate(Long id) {
        Member member = em.find(Member.class, id);
        member.hitUpdate();
        member.downStrike();
        member.hitRateUpdate();
        em.persist(member);
        em.flush();
    }

    public void outUpdate(Long id){
        Member member = em.find(Member.class, id);
        member.outUpdate();
        em.persist(member);
        em.flush();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
