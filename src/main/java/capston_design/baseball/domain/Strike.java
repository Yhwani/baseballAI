package capston_design.baseball.domain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Strike {   // AI 모델에서 받아올 JSON 파일 DTO
    private boolean strike;
}
