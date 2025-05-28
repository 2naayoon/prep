package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ChangeDto {
    private String userid;
    private String password; // 현재 비밀번호
    private String newPassword; // 새 비밀번호
    private String confirmPassword; // 확인 비밀번호

    public boolean newPasswordEqualsConfirmPassword() {
        return newPassword.equals(confirmPassword);
    }
}
