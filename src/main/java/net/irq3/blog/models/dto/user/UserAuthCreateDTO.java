package net.irq3.blog.models.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserAuthCreateDTO{
    String name;
    String email;
}
