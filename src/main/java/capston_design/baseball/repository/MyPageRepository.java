package capston_design.baseball.repository;

import capston_design.baseball.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyPageRepository {

    private final EntityManager em;

    public List<Member> teamInformation(Member member) {
        return em.createQuery("select m from Member m where m.team = :team" , Member.class)
                .setParameter("team", member.getTeam())
                .getResultList();
    }

}
