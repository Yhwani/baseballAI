package capston_design.baseball.repository;

import capston_design.baseball.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinRepository {

    private final EntityManager em;

    @Transactional
    public void join(Member member) {
        member.hitRateUpdate();
        em.persist(member);
        em.flush();
        em.clear();
    }

    public List<Member> findByAll(String nameId){
        return em.createQuery("select m from Member m where m.nameId = :nameId", Member.class)
                .setParameter("nameId", nameId)
                .getResultList();
    }
}
