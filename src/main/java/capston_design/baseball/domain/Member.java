package capston_design.baseball.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;        // 선수 고유번호

    private String name;    // 선수 이름
    private String team;    // 선수 팀
    private Long strike;    // 선수 스트라이크 수
    private Long ball;      // 선수 볼 수
    private Long hit;       // 선수 안타 수
    private Long out_;      // 선수 아웃 수
    private Double hitRate;   // 선수 타율

    @NotEmpty
    private String nameId;      // 계정 아이디
    @NotEmpty
    private String password;// 계정 비밀번호

    public void update(boolean strike1){
        if (strike1){
            strike++;
        } else{
            ball++;
        }
    }
    public void hitUpdate(){
        hit++;
    }
    public void outUpdate(){
        out_++;
    }
    public void downStrike(){
        strike--;
    }
    public void hitRateUpdate(){
        hitRate = Double.parseDouble(String.format("%.3f", (double) hit / (double) (strike + ball + hit)));
    }
}
