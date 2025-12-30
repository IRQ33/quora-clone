package net.irq3.blog.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateDTO {
    @Size(max = 80)
    private String userName;
    @Email
    private String email;
    @Size(min = 8, max = 150)
    private String password;
}
