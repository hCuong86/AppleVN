package poly.edu.asmjava5.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminLoginDto implements Serializable {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    private Boolean rememberMe = false;
}
