package capston_design.baseball.repository;

import capston_design.baseball.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final EntityManager em;

    public Optional<Member> findByLoginId(String nameId) {
        return findAll().stream()
                .filter(m -> m.getNameId().equals(nameId))
                .findFirst();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}
