package capston_design.baseball.service;

import capston_design.baseball.domain.Member;
import capston_design.baseball.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public Member login(String nameId, String password) {
        return loginRepository.findByLoginId(nameId).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
