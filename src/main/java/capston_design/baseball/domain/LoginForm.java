package capston_design.baseball.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {        // 로그인 위한 DTO

    @NotEmpty
    private String nameId;
    @NotEmpty
    private String password;

}
